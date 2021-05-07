package com.example.demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLDemo {
    public static void main(String[] args) {
        Object o  =new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized (o){
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
        try{
            Thread.sleep(4000);
        }catch (Exception e){

        }
        Object o2  =new Object();
        System.out.println(ClassLayout.parseInstance(o2).toPrintable());
    }
}
