/**
 * 
 * 
 * Concepts :
 * 
 * synchronized methods
 * 
 * synchronized blocks
 * 
 * lamda expressions as single-abstract-method interface (SAM)
 *
 * 
 */

public class Synchronization
{
    private int counter = 0; // to demo synchronized method
    private double balance = 0; // // to demo synchronized blocks
    
    //Following is "synchronized method" concept in java
    //public void increment () {
    public synchronized void incrementCounter () {
        counter++;
    }
    
    public int getCounter () {
        return counter;
    }
    
    public void deposit (double inAmount) {
        synchronized (this) {
        //{
            balance+=inAmount;
        }
    }
    
    public void withdraw (double inAmount) {
        synchronized (this) {
        //{
            balance-=inAmount;
        }
    }
    
    public double getBalanceAmount () {
        synchronized (this) {
        //{
            return balance;
        }
    }
    
    public static void main(String[] args) {
    
        Synchronization counterExample = new Synchronization();
        /*
         * A lambda expression can be used to provide the code that the thread will execute
         * In this case, the lambda expression defines a 
         * single-abstract-method interface (SAM) compatible with the Runnable interface.
         */ 
        Thread thread1 = new Thread (() -> {
            for (int i = 0; i<5 ; i++ ) {
                counterExample.incrementCounter();
                System.out.println("Present count" + counterExample.getCounter());
            }
            
        });

        Thread thread2 = new Thread (() -> {
            for (int i = 0; i<10 ; i++ ) {
                counterExample.incrementCounter();
                System.out.println("Present count" + counterExample.getCounter());
            }
            
        });

        System.out.println("Main thread start Present count " + counterExample.getCounter());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Expected is 15 , Present count" + counterExample.getCounter());

        thread1 = null;
        thread2 = null;

        Thread thread3 = new Thread (() -> {
            int amount = 500;
            for (int i = 0; i<3 ; i++ ) {
                counterExample.deposit(amount);
                System.out.println("Present balance after deposit " + counterExample.getBalanceAmount());
                amount+=100;
            }
            
        });

        Thread thread4 = new Thread (() -> {
            int amount = 100;
            for (int i = 0; i<3 ; i++ ) {
                counterExample.withdraw(amount);
                System.out.println("Present balance after withdrawal " + counterExample.getBalanceAmount());
                amount+=100;
            }
            
        });

        // Note that concurrrency is different from Synchronization
        System.out.println("Main thread start Present balance " + counterExample.getBalanceAmount());

        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Note that concurrrency is different from Synchronization
        System.out.println("Final Counter balance expected  1200 , Present balance " + counterExample.getBalanceAmount());

        thread3 = null;
        thread4 = null;
    }
}
