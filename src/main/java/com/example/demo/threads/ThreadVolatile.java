package com.example.demo.threads;
import  sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadVolatile {
    static  volatile  int  invVal =0;

    public static void main(String[] args) {
//        for(int i=0;i<10;i++){
//            new Thread(()->
//            {
//                for(int j=0;j<100;j++){
//                    invVal++;
//                }
//            }
//                    ).start();
//        }
//        //保证之前启动的全部线程执行完毕
//        while (Thread.activeCount()>1){
//            Thread.yield();
//            System.out.println(invVal);
//        }
        qoa();
    }


    public static void   qoa(){
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<100;j++){
                    try {
                        //通过反射获取Unsafe类
                        Field theUnsafe  = Unsafe.class.getDeclaredField("theUnsafe");
                        theUnsafe.setAccessible(true);
                        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
                        unsafe.getAndAddInt(ReentrantLock.class,invVal,1);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
                    while (Thread.activeCount()>1){
            Thread.yield();
            System.out.println(invVal);
        }
        }
    }
}
