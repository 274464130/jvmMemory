package com.example.demo.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public  static  void   getFruitInfo(Class<?>  clazz){
         String strFruitNmae="水果名称";
        String strFruitColor ="水果颜色";
        String strFruitProicne="供应商信息";
        Field[] fields =clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName =(FruitName)field.getAnnotation(FruitName.class);
                strFruitNmae=strFruitNmae+fruitName.value();
                System.out.println(strFruitNmae);
            }else  if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor =strFruitNmae+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider =field.getAnnotation(FruitProvider.class);
                strFruitProicne="供应商比编号："+fruitProvider.id()+"供应商名称"+fruitProvider.name()+
                        "地址"+fruitProvider.address();
                System.out.println(strFruitProicne);
            }
        }
    }

}
