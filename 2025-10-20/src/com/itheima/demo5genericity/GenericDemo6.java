package com.itheima.demo5genericity;

import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        //目标：搞清楚泛型和集合不支持基本数据类型，只能支持对象类型(引用数据类型)
        ArrayList<Integer> list = new ArrayList<>();//错误
        //泛型的擦除：泛型工作在编译阶段，等编译结束后没用了，所以编译后泛型会被擦除 被恢复成Object
        list.add(12);
        // Object o = 12; 但是Object 只能接对象 但是12不是对象 所以有包装类 把基本数据类包装成对象类型

        //手动包装
        Integer i = Integer.valueOf(12);//-128 - 127 是同一个对象 其他就是不同的对象了
        Integer a = Integer.valueOf(129);
        Integer b = Integer.valueOf(129);
        System.out.println(i == a);

        //自动装箱
        Integer c = 12;
        Integer d = 12;
        System.out.println(c == d);
        //自动拆箱 把包装类转换成基本数据类型
        int e = c;
        int f = d;
        //自动装箱拆箱
        list.add(129);
        int m = list.get(1);
        System.out.println("-----------------------------");

        //包装类新增的功能
        //1. 把基本数据类型转换成字符串
        int j = 23;
        String s = Integer.toString(j);//静态方法
        System.out.println(s+1);
        Integer k = 22;
        String s2 = k.toString();

        //2. 把字符串转换成基本数据类型
        String s3 = "123";
        int l = Integer.parseInt(s3);
        int l1 = Integer.valueOf(s3);
        System.out.println(l+100);
        String s4 = "98.5";
        double n = Double.parseDouble(s4);
        double n1 = Double.valueOf(s4);
        System.out.println(n+0.1);
    }
}
