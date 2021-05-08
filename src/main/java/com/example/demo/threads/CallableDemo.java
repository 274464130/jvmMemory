package com.example.demo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class  MyThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("call--------");
        return 1000;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"aaa").start();

        System.out.println("1111111111111");
       Integer  i= futureTask.get();

        System.out.println(i+1);

    }
}
