package com.example.demo.algorithm;

public class FibonacciNumber {
    /**
     * 斐波那契数列双指针移动算法
     * @param num
     * @return
     */
    public static long doublepointer(int num){
        if(num==0) return  0;
        if(num==1)  return  1;
        long low =0  ,hig=1;
        for(int i=2;i<=num;i++){
            long sum =low+hig;
            low=hig;
            hig=sum;
        }
        return  hig;
    }

    public static void main(String[] args) {
        System.out.println( doublepointer(600000));
    }
}
