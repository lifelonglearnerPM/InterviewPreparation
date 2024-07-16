// Note since Runnable is interface we use "implements" and not "extends"

public class MultiThreadBasic2 {

    public static void main (String[] args) {
        System.out.println("Main Thread started");
        
        /*
        Runnable runnable = new MyRunnable(); Creates an object of a class (MyRunnable) that 
        implements the Runnable interface. This interface defines the run method that contains 
        the tasks the thread will execute.
        Thread thread = new Thread(runnable); Creates a new Thread object, 
        passing the runnable object as a constructor argument. 
        This connects the thread to the code it will run (MyRunnable.run).
        
        Following code combines 
        Runnable runnable = new ThreadBasic2(); and Thread exampleThread = new Thread(runnable);
        */
        Thread exampleThread1 = new Thread(new UsingRunnable("Thread 1"));
        Thread exampleThread2 = new Thread(new UsingRunnable("Thread 2"));
        
        exampleThread1.start();
        exampleThread2.start();
        
        /*
            By using thread.join(), the main thread is forced to wait 
            for the created thread to complete its tasks before the main thread itself finishes.
            
            when only  exampleThread.join(); used without error handling
            error : unreported exception InterruptedException; must be caught or declared to be thrown
            
        */
        ///*
        try {
 
            exampleThread1.join();
            exampleThread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //*/
        
        System.out.println("Main Thread ended");
        
    }
}

class UsingRunnable implements Runnable{
    private final String name;
    
    public UsingRunnable (String inName){
        //this.name = inName;
        name = inName;
    }
    
    @Override public void run ()
    {
        //for (int i = 0; i< 5 ; i++)
        System.out.println("Print from : " + name);
    }
}
