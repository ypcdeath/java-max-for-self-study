package com.itheima.demo4genericity;

import com.itheima.demo3genericity.Student;

public class GenericDemo4 {
    public static void main(String[] args) {
        //目标：学会定义泛型方法，搞清楚作用
        //打印任意数组的内容
        String[] name = {"张三","李四","王五"};
        printArray(name);
        Student[] students = new Student[3];
    }

    public static <T> void printArray(T[] arr){
        for (T t : arr) {
            System.out.println(t);
        }
    }
}
