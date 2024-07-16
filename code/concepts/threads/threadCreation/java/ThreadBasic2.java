// Note since Runnable is interface we use "implements" and not "extends"

public class ThreadBasic2  implements Runnable {
    
    public static int counter = 0;
    
    @Override public void run ()
    {
        //for (int i = 0; i< 5 ; i++)
        System.out.println("Current counter value: " + (++counter));
    }
    

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
        Thread exampleThread = new Thread(new ThreadBasic2());
        
        exampleThread.start();
        
        /*
            By using thread.join(), the main thread is forced to wait 
            for the created thread to complete its tasks before the main thread itself finishes.
            
            when only  exampleThread.join(); used without error handling
            error : unreported exception InterruptedException; must be caught or declared to be thrown
            
        */
        ///*
        try {
 
            exampleThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //*/
        
        System.out.println("Main Thread ended");
        
    }
}
