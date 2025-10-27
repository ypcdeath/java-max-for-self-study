package com.itheima.demo2genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
        //目标：创建自己的泛型类
        MyArrayList<String> list = new MyArrayList<>();//结束了
        list.add("hello");
        list.add("world");
        list.add("java");
        list.remove("java");
        System.out.println(list.get(0));
    }
}
