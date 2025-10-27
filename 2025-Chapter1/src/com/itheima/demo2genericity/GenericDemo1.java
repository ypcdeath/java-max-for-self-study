package com.itheima.demo2genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        //目标：认识泛型 搞清楚泛型的好处
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add(123);
        list.add(true);
        list.add(100);
        list.add(new Object());
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");
        list1.add("world");
        list1.add("java");
        list1.add("hello");
        list1.add("world");
        //就像是厕所 有男女的标识 男只能进男厕所 女只能进女厕所
    }
}
