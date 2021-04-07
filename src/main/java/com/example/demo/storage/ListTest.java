package com.example.demo.storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {


    public static void main(String[] args) {
        Long  start = System.currentTimeMillis();
        removeEvensvar(arrayListLength(800000));
        Long  end = System.currentTimeMillis();
        System.out.println(end-start);
        removeEvensvar(linkListlength(800000));
        Long  end1 = System.currentTimeMillis();
        System.out.println(end1-start);
    }

    public static List<Integer>    arrayListLength(int  i){
        List<Integer> list = new ArrayList<>();
        for (int j=0;j<=i;j++){
            list.add(j);
        }

        return  list;
    }

    public static List<Integer>  linkListlength(int  i){
        List<Integer> list = new LinkedList<>();
        for (int j=0;j<=i;j++){
            list.add(j);
        }
        return  list;
    }

    public  static  void removeEvensvar(List<Integer> list){
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            if(itr.next()%2==0){
                itr.remove();
            }
        }
    }

}
