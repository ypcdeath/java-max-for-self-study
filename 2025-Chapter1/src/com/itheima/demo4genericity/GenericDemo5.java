package com.itheima.demo4genericity;

import java.util.ArrayList;

public class GenericDemo5 {
    public static void main(String[] args) {
        //目标： 理解通配符和上下限
    }

    public static void go(ArrayList<? extends Car> cars){

    }

    public static void go2(ArrayList<? super Car> cars){

    }
}
