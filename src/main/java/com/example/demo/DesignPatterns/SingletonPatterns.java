package com.example.demo.DesignPatterns;

/**
 * 双检索单例模式
 */
public class SingletonPatterns {
    private static SingletonPatterns singletonPatterns;
    private SingletonPatterns(){}
    private static SingletonPatterns getInstance(){
            if(singletonPatterns==null){
                    synchronized (SingletonPatterns.class){
                        if(singletonPatterns==null){
                            singletonPatterns= new SingletonPatterns();
                        }
                    }
            }
            return  singletonPatterns;
    }
}
