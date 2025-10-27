package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //目的：搞清楚Collection集合的特点
        //1. List家族的集合：有序、可重复，有索引
        List<String> list = new ArrayList<>();//多态
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        System.out.println(list);//[hello, world, java, world]
        System.out.println(list.get(0));

        System.out.println("-----------------------");
        //2. Set家族的集合：无序、不可重复，没有索引
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("world");
        System.out.println(set);
        System.out.println(set.size());

    }
}
