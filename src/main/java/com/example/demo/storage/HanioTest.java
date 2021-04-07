package com.example.demo.storage;

/**
 * 汉罗塔问题
 */
public class HanioTest {

    /**
     *
     * @param n  第n步
     * @param from    A 主
     * @param to   C 柱
     */
    int i=0;
    public    void  hanio(int n,char from ,char to){
        System.out.println("第"+i++ +"步"  +"移动盘子号"+n+"从"+from+"移动到"+to);
    }


    void  move(int n, char start,char   tranm ,char   end){
        if(n<=1){
            hanio(n,start,end);
        }else{
            move(n-1,start,end,tranm);
            hanio(n-1,start,tranm);
        }
    }
}
