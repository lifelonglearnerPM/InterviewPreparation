/**
 * producer consumer problem statement : 
 * The Producer-Consumer problem is a classic synchronization problem. 
 * There are two types of threads: the producer and the consumer. 
 * The producer generates data and puts it into a shared buffer, 
 * while the consumer takes the data out of the buffer for processing. 
 * The challenge is to make sure that the producer does not add data when 
 * the buffer is full and the consumer does not take data when the buffer is empty, 
 * ensuring proper synchronization between the producer and consumer threads.
 * 
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main (String[] args) throws InterruptedException {
        BlockingQueue <Integer> buffer = new ArrayBlockingQueue <>(5);
        
        Thread producer = new Thread (()->{
            try {
                for (int i = 1; i <= 10 ; i++ )
                {
                    buffer.put(i);
                    System.out.println ("Produced : "+ i);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        
        Thread consumer = new Thread(()->{
            try {
                for (int i = 1; i < 7 ; i++)
                {
                    int bufferItem = buffer.take();
                    System.out.println ("Consumed : "+ bufferItem);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
    }
}