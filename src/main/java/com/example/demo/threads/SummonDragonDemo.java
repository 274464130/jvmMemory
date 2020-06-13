package com.example.demo.threads;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 线程计数器Demo
 */
public class SummonDragonDemo {

    private  static  final  int  THREAD_COUNT_NUM=7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<THREAD_COUNT_NUM;i++){
            int index =i;
            new Thread(()-> {
                try {
                    System.out.println("第"+index);
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            }).start();

        }
        countDownLatch.await();
        System.out.println("dsadasd");
    }
}
