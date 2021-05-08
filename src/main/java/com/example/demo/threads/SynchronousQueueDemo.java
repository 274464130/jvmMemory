package com.example.demo.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue  blockingQueue = new SynchronousQueue();
         new Thread(()->{

             try {
                 System.out.println(Thread.currentThread().getName()+"///111");
                 blockingQueue.put(1);
                 System.out.println(Thread.currentThread().getName()+"///2");
                 blockingQueue.put(2);
                 System.out.println(Thread.currentThread().getName()+"///3");
                 blockingQueue.put(3);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"aa").start();
         new  Thread(()->{
             System.out.println(Thread.currentThread().getName()+"///111");
             try {
                 blockingQueue.take();
                 System.out.println(Thread.currentThread().getName()+"///2");
                 TimeUnit.SECONDS.sleep(5);
                 blockingQueue.take();
                 TimeUnit.SECONDS.sleep(5);
                 System.out.println(Thread.currentThread().getName()+"///3");
                 TimeUnit.SECONDS.sleep(5);
                 blockingQueue.take();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         },"bbb").start();
    }
}
