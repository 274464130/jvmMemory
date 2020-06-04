package com.example.demo.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TeskTask implements  Runnable {
    private ConcurrentHashMap<Integer,Integer>  map;

    public  TeskTask(ConcurrentHashMap<Integer,Integer> map){
        this.map=map;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            map.put(1,map.get(1)+1);
        }
    }


}
class  Test{
    public static void main(String[] args) {
        int threadNum =3;
        System.out.println("单线程");
        for(int i=0;i<5;i++){
            System.out.println("第"+i+"次运行结果"+testadd(threadNum));
        }
    }

    private static  int testadd(int num){
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
        map.put(1,0);
        ExecutorService  poll = Executors.newCachedThreadPool();
        for (int i=0;i<num;i++){
            poll.execute(new TeskTask(map));
        }
        poll.shutdown();

        try {
            poll.awaitTermination(20, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  map.get(1);
    }
}
