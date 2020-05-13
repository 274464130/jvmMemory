package com.example.demo.storage;

import org.openjdk.jol.info.ClassLayout;

public class MemoryLayout {
    public static void main(String[] args) {
        Object o = new Object();
        // new object的  内存分布

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


}
