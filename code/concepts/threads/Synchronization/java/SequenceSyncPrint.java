/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Problem statement :
 * Using 3 threads print 1,2,3,4,5 ... in sequence
 *******************************************************************************/

public class SequenceSyncPrint
{
    int counter = 1; // we need to sync this shared int
    int maxNumThread = 3;
    int counterLimit = 15;
    
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private Object lock3 = new Object();
    
    public void displaySequence (int threadID) throws InterruptedException {
        while (counter <= counterLimit)
            switch (threadID) {
                case 1 :
                    synchronized (lock1) {
                        while(counter % maxNumThread != 1) {
                            lock1.wait();
                        }
                        synchronized (lock2) {
                            if (counter > counterLimit) {
                                lock2.notifyAll();
                                return;
                            }
                        }
                        /*
                        if (counter <= counterLimit) counter++;
                        else notifyall ();
                        */
                        System.out.println("Print from " + threadID +" : " +counter);
                        synchronized (lock2) {
                            if (counter <= counterLimit) counter++;
                            lock2.notify();
                        }
                    }
                    break;
                case 2 :
                    synchronized (lock2) {
                        while(counter % maxNumThread != 2) {
                            lock2.wait();
                        }
                        synchronized (lock3) {
                            if (counter > counterLimit) {
                                lock3.notifyAll();
                                return;
                            }
                        }
                        System.out.println("Print from " + threadID +" : " +counter);
                        /*
                        if (counter <= counterLimit) counter++;
                        else lock3.notifyall ();
                        */
                        synchronized (lock3) {
                            if (counter <= counterLimit) counter++;
                            lock3.notify();
                        }
                    }
                    break;
                case 3 :
                    synchronized (lock3) {
                        while(counter % maxNumThread != 0) {
                            lock3.wait();
                        }
                        synchronized (lock1) {
                            if (counter > counterLimit) {
                                lock1.notifyAll();
                                return;
                            }
                        }
                        System.out.println("Print from " + threadID +" : " +counter);
                        /*
                        if (counter <= counterLimit) counter++;
                        else lock1.notifyall
                        */
                        synchronized (lock1) {
                            if (counter <= counterLimit) counter++;
                            lock1.notifyAll();
                        }
                    }
                    break;
            }
        
    }
    
    private final Object lock = new Object();
    boolean done = false;
    
    public void printSequence (int threadID) throws InterruptedException {
        while (counter <= counterLimit) {
            synchronized (lock)
            {
                //while (counter % maxNumThreads != threadID - 1)
                //while (counter % maxNumThread != threadID % maxNumThread) {
                while (counter % maxNumThread != threadID % maxNumThread && !done) {
                    lock.wait();
                }
                if (done || counter >counterLimit) {
                    done = true;
                    lock.notifyAll();
                    return;
                }
                System.out.println("Print from " + threadID +" : " +counter);
                counter++;
                lock.notifyAll();
            }
            
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        SequenceSyncPrint printer = new SequenceSyncPrint();
        
        /*
        Thread thread1 = new Thread (()->{
            try {
                printer.displaySequence(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Thread thread2 = new Thread (()->{
            try {
                printer.displaySequence(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Thread thread3 = new Thread (()->{
            try {
                printer.displaySequence(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        */
        
        Runnable task1 = () -> {
            try {
                printer.printSequence(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                printer.printSequence(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Runnable task3 = () -> {
            try {
                printer.printSequence(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}