package com.example.demo.threads;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class MutexLock {
    private AtomicReference<Thread>  owner =  new AtomicReference<>();

    private LinkedList<Thread> list = new LinkedList<>();
    public  void lock(){
        //Thread.currentThread()可以获取当前线程的引用，一般都是在没有线程对象又需要获得线程信息时通过Thread.currentThread()获取当前代码段所在线程的引用
        Thread currnetThread = Thread.currentThread();
        //没有任何线程持有锁时，让当前线程持有锁，反正则加入等待队列并阻塞
        if(!owner.compareAndSet(null,currnetThread)){
            list.add(currnetThread);
            //LockSupport阻塞当前线程
            LockSupport.park();
        }


    }


    public  void unlock(){
        //如果解锁的线程不是持有锁的线程，那么抛出异常
        if(Thread.currentThread()!=owner.get())throw  new RuntimeException();
        //等待对立有内容时，恢复队头线程，更改持有锁的线程，反之则直接释放锁
        if(list.size()>0){
            Thread t = list.poll();
            owner.set(t);
            //释放指定线程
            LockSupport.unpark(t);
        }else {
            owner.set(null);
        }
    }
}
