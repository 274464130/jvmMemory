package com.example.demo.threads;

import cn.hutool.core.util.IdUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new  ArrayList<>();
        for(int i =0;i<40;i++){
            new Thread(()->{
                list.add(IdUtil.randomUUID().substring(0,9));
                System.out.println(list);
            }

            ).start();
        }
    }

    // 解决方法 Collections.synchronizedList() Vector<>()
}
