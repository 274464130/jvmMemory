package com.example.demo.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void  put(String  str){
        readWriteLock.writeLock().lock();
        try {

            System.out.println(str+"正在写入");
            map.put(str,1);
            TimeUnit.MILLISECONDS.sleep(300);

            System.out.println(str+"正在完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void  get(String  str){
        readWriteLock.readLock().lock();
        try {
            System.out.println(str+"正在读取");
            TimeUnit.MILLISECONDS.sleep(300);
            map.get(str);
            System.out.println(str+"读取完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }



    }

}
public class ReadWriteLoadDemo {
    public static void main(String[] args) {

        Mycache mycache = new Mycache();
        for(int i=0;i<5;i++){
            int finalI = i;
            new Thread(()->{
                mycache.put(""+ finalI +"");
            }).start();
        }
        for(int i=0;i<5;i++){
            int finalI = i;
            new Thread(()->{
                mycache.get(""+ finalI +"");
            }).start();
        }
    }
}
