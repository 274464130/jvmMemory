package com.example.demo.threads;

import cn.hutool.core.util.StrUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class  MyResource{
    private  volatile   boolean FLAG=true;
    private AtomicInteger  atomicInteger = new AtomicInteger();
    BlockingQueue<String>  blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void  myprod() throws InterruptedException {
        boolean  result;
        while (FLAG){
            result  =  blockingQueue.offer(  atomicInteger.incrementAndGet()+"",2, TimeUnit.SECONDS);
            if(result){
                System.out.println(Thread.currentThread().getName()+"、生产了"+atomicInteger);
            }else{
                System.out.println(Thread.currentThread().getName()+"、生产了失败"+atomicInteger);
            }
            TimeUnit.SECONDS.sleep(2);

        }


        System.out.println( "停止 ---生产结束");


    }


    public  void   myconsumer() throws InterruptedException {
        String result;
        while (FLAG){

            result=     blockingQueue.poll(2,TimeUnit.SECONDS);
            if(StrUtil.hasEmpty(result)){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"没有东西消费了"+result);
                return;
            }else {
                System.out.println(Thread.currentThread().getName()+"消费成功"+result);
            }


        }

        System.out.println( "消费结束");


    }

    public  void  stop(){
        this.FLAG=false;
    }
}


public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(6));
         new Thread(()->{
             System.out.println("生产者 来电了");
             try {
                 resource.myprod();

             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"prod").start();
        new Thread(()->{
            try {
                System.out.println("消费者来电了");
                resource.myconsumer();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();
        TimeUnit.SECONDS.sleep(10);
        resource.stop();


    }
}
