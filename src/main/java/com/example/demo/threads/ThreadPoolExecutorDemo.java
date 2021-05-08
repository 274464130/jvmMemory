package com.example.demo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
//        ExecutorService  executorService = Executors.newFixedThreadPool(5);
//        ExecutorService  executorService = Executors.newSingleThreadExecutor();
        ExecutorService  executorService = Executors.newCachedThreadPool();

        for (int i=0;i<20;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"///");
            });
        }
        executorService.shutdown();

    }
}
