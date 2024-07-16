
public class ThreadBasic1 extends Thread
{
    
    public static int counter = 0;
    
    @Override public void run ()
    {
        //for (int i = 0; i< 5 ; i++)
        System.out.println("Current counter value: " + (++counter));
    }
    
    
    public static void main (String[] args) 
    {
        System.out.println("Main Thread started");
        
        ThreadBasic1 exampleThread = new ThreadBasic1();
        
        exampleThread.start();
        
        /*
        By using thread.join(), the main thread is forced to wait 
        for the created thread to complete its tasks before the main thread itself finishes.
        
        when only  exampleThread.join(); used without error handling
        error : unreported exception InterruptedException; must be caught or declared to be thrown
        
        */
        
        ///*
        try 
        {
            exampleThread.join();
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //*/
        
        System.out.println("Main Thread ended");
    }
}
