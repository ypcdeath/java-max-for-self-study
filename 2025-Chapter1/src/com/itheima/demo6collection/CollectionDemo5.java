package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CollectionDemo5 {
    public static void main(String[] args) {
        //目标： 集合的3种遍历方式
        //三，foreach遍历
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        names.add("田七");
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        names.forEach(System.out::println);
    }
}
