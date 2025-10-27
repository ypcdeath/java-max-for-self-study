package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo6 {
    public static void main(String[] args) {
        //目标： 认识并发修改异常问题，搞清楚每种遍历的区别
        ArrayList<String> list = new ArrayList<>();
        list.add("java入门");
        list.add("java实战");
        list.add("C语言入门");
        list.add("C语言进阶");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("红枸杞");
        //需求1.删除所有枸杞
//        for(int i = 0;i<list.size();i++){
//            String name = list.get(i);
//            if(name.contains("枸杞")){
//                list.remove(name);
//                i--;
//            }
//        }
        for (int i = list.size()-1;i>=0;i--){
            String name = list.get(i);
            if(name.contains("枸杞")){
                list.remove(name);
            }
        }
        System.out.println(list);
        //为什么没有删干净呢 删除后后面没有校验的元素到了我们当前的索引处，就不会再校验后面一个了
        //1. i-- 2. 倒着遍历
        System.out.println("=============================================");
        Collection<String> list2 = new ArrayList<>();
        list2.add("java入门");
        list2.add("java实战");
        list2.add("C语言枸杞");
        list2.add("Java枸杞");
        list2.add("C语言入门");
        list2.add("C语言进阶");
        list2.add("宁夏枸杞");
        list2.add("黑枸杞");
        list2.add("红枸杞");
        System.out.println(list2);
        //方案一：迭代器遍历删除 也存在并发修改异常问题
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if(name.contains("枸杞")){
                it.remove();
            }
        }
        System.out.println(list2);
        //没有索引只能用迭代器遍历来解决

        //for和lambda只适合遍历 不适合遍历并修改操作
    }
}





















