public class MultiThreadBasic3 {
    public static void main (String[] args) {
        System.out.println("Main Thread started");
        UsingThreadClass exampleThread1 = new UsingThreadClass("Thread 1");
        UsingThreadClass exampleThread2 = new UsingThreadClass("Thread 2");
        
        exampleThread1.start();
        exampleThread2.start();
        
        try{
            exampleThread1.join();
            exampleThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread ended");
    }
}

class UsingThreadClass extends Thread {
    private final String name;
    
    public UsingThreadClass (String inName) {
        //this.name = inName;
        name = inName;
    }
    
    @Override public void run () {
        System.out.println("Print from : "+ name);
    }
}