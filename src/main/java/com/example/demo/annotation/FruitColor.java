package com.example.demo.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color{BLUE,RED,GREEN};

    Color fruitColor() default Color.RED;
}
