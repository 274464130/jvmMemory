package com.example.demo.storage;

        import org.openjdk.jol.info.ClassLayout;

public class MemoryLayout {
    public static void main(String[] args) {
        Object o = new Object();
        // new object的  内存分布
        // 1 markword   8个字节    2 类的指针   class  pointer  3   实例数据    4  padding  可有可无
        //加起来一定可以被8整除

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


}
