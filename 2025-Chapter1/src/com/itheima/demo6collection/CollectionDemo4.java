package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo4 {
    public static void main(String[] args) {
        //目标： 集合的3种遍历方式
        //二.增强for遍历
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
