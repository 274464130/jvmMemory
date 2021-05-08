package com.example.demo.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShartDamo{
    private int  number=1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 =lock.newCondition();
    private Condition condition2 =lock.newCondition();
    private Condition condition3 =lock.newCondition();

    public   void  print(String str){
            lock.lock();
        try {
            while (number!=1){
                condition1.await();
            }
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"//"+i);
            }
            number=2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public  void  print10(String str){
        lock.lock();
        try {
            while (number!=2){
                condition2.await();
            }
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"//"+i);
            }
            number=3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public  void  print15(String str){
        lock.lock();
        try {
            while (number!=3){
                condition3.await();
            }
            for (int i=0;i<15;i++){
                System.out.println(Thread.currentThread().getName()+"//"+i);
            }
            number=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }



}

/**
 * ABC 三个线程循环打印
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShartDamo shartDamo = new ShartDamo();
        new Thread(()->{
            for (int i=0;i<5;i++){
                shartDamo.print("a");
            }
        },"A").start();
        new Thread(()->{
            for (int i=0;i<5;i++){
                shartDamo.print10("a");
            }
        },"b").start();
        new Thread(()->{
            for (int i=0;i<5;i++){
                shartDamo.print15("a");
            }
        },"c").start();
    }
}
