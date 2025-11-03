package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        //目标： 创建Stream流 认识stream流
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张小四");

        //先用传统方案，找到姓张的人，名字为三个字的，存到一个新集合里
        List<String> ZhangList = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张") && name.length() == 3){
                ZhangList.add(name);
            }
        }
        System.out.println(ZhangList);

        ZhangList = list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).collect(Collectors.toList());
        //Stream流 相当于一个流水线

    }
}
