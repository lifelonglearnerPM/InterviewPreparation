public class MultiThreadBasic1 
{
    
    public static void main (String[] args) 
    {
        System.out.println("Main Thread started");
        
        UsingThreadClass exampleThread1 = new UsingThreadClass();
        Thread exampleThread2 = new Thread(new UsingRunnable());
        
        exampleThread1.start();
        exampleThread2.start();
        
        /*
        By using thread.join(), the main thread is forced to wait 
        for the created thread to complete its tasks before the main thread itself finishes.
        
        when only  exampleThread.join(); used without error handling
        error : unreported exception InterruptedException; must be caught or declared to be thrown
        
        */
        
        ///*
        try 
        {
            exampleThread1.join();
            exampleThread2.join();
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //*/
        
        System.out.println("Main Thread ended");
    }
}

class UsingRunnable implements Runnable {
    @Override public void run ()
    {
        //for (int i = 0; i< 5 ; i++)
        System.out.println("Runnable Thread print");
    }
}

class UsingThreadClass extends Thread {
    @Override public void run ()
    {
        //for (int i = 0; i< 5 ; i++)
        System.out.println("Thread Class Thread print");
    }
}
