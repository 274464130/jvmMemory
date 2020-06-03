package com.example.demo.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
   static CountDownLatch  latch  = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {

        ths();
        try {
            latch.getCount();
            latch.await();
        }catch (Exception e){

        }
      if(0==latch.getCount()) {
          System.out.println("总结束");
      }
         ;


    }

    public static void   ths(){

        new Thread(()->{
            try {
                System.out.println("开始执行第一段代码");

                Thread.sleep(2000);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("1结束");
           // 调用countDown -1
            latch.countDown();

        }).start();
        new Thread(()->{
            try {
                System.out.println("开始执行第2段代码");

                Thread.sleep(2000);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("2结束");
            latch.countDown();

        }).start();



    }
}
