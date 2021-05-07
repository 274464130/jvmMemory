package com.example.demo.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread>  atomicReference  = new AtomicReference<>();

    public void  mylock(){

        Thread thread= Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"//sds");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public  void myunlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"//un");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo= new SpinLockDemo();
        new Thread(()->{
            try {
                spinLockDemo.mylock();
                TimeUnit.SECONDS.sleep(5);
                spinLockDemo.myunlock();
            }catch (InterruptedException  e){
                e.printStackTrace();
            }
        },"AA") .start();
       try { TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e) {
       }
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                spinLockDemo.mylock();
                spinLockDemo.myunlock();
            }catch (InterruptedException  e){
                e.printStackTrace();
            }
        },"bb") .start();

    }



}
