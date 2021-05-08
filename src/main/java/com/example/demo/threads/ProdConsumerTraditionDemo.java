package com.example.demo.threads;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate{
    private int number=0;
    private Lock lock=  new ReentrantLock();
    private Condition condition =lock.newCondition();


    public  void incerment(){
        //1判断
        lock.lock();
        try {
            while (number!=0){
                condition.await();

            }
            number++;
            System.out.println(Thread.currentThread().getName()+"///"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void  decrement(){
             lock.lock();

            try {
                while (number==0){
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"///"+number);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


    }


}

public class ProdConsumerTraditionDemo   {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();
         new  Thread(()->{
             for (int i=1;i<6;i++){
                 shareDate.incerment();
             }

         },"aa").start();
        new  Thread(()->{
            for (int i=1;i<6;i++){
                shareDate.decrement();
            }

        },"bb").start();
    }
}
