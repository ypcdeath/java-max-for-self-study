package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //目的：搞清楚collection提供的通用集合功能
        Collection<String> list = new ArrayList<>();
        //1. 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        //2. 获取元素个数
        int size = list.size();
        System.out.println(size);
        //3. 判断集合是否为空
        boolean empty = list.isEmpty();
        System.out.println(empty);
        //4. 删除元素
        list.remove("hello");
        System.out.println(list);
        //5. 判断集合中是否包含某个元素
        boolean contains = list.contains("world");
        System.out.println(contains);
        //6. 获取集合中的所有元素
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString( objects));
        //7. 清空集合
        list.clear();
        System.out.println(list);
        boolean empty1 = list.isEmpty();
    }
}
