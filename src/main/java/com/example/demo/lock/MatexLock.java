package com.example.demo.lock;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class MatexLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private LinkedList<Thread> waiterQueue = new LinkedList<>();
    private volatile AtomicInteger state = new AtomicInteger();
    public  void  lock (){
        Thread currentThread = Thread.currentThread();
        // 如果请求锁的线程是当前线程
        if(owner.get()==currentThread){
            state.incrementAndGet();
            return;
        }
        //没有任何线程持有锁时，让当前线程持有锁，反之则加入等待队列并阻塞
        if(!owner.compareAndSet(null,currentThread)){
            waiterQueue.add(currentThread);
            //LockSuport 阻塞当前线程
            LockSupport.park();
        }
    }

    public  void  unLock() {
        //如果解锁的线程不是持有锁的线程，那么抛出异常
        if (Thread.currentThread() != owner.get()) {
            throw new RuntimeException();
        }
        //计数器清空只有才能继续之后的操作
        if (state.get() > 0) {
            state.decrementAndGet();
            return;
        }
        //等待队列里由内容时，释放指定队列，更改持有锁的线程，反之贼清空持有锁的线程
        if(waiterQueue.size()>0){
            Thread t  = waiterQueue.poll();
            owner.set(t);
            LockSupport.unpark(t);
        }else {
            owner.set(null);
        }
    }
}
