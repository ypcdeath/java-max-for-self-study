package com.itheima.demo7list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //目标：掌握List集合的独有功能
        List<String> list = new ArrayList<>();
        //添加点人名
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("田七");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.set(1,"小王"));
        System.out.println(list);
        System.out.println(list.indexOf("小王"));
        //4种遍历方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String name : list) {
            System.out.println(name);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        list.forEach(name -> System.out.println(name));
    }
}
