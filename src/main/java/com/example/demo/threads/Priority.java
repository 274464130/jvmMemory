package com.example.demo.threads;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.ArrayList;
import java.util.List;

public class Priority {
  static   volatile boolean  noStart =false;
  static  volatile  boolean noEnd = false;

    public static void main(String[] args) {
        List<BatchProperties.Job>   jos = new ArrayList<>();
        for(int i =0 ;i<10;i++){

        }
    }
}
