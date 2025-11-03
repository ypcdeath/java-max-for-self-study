package com.itheima.testdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo2 {
    public static void main(String[] args) {
        //1. Collections 批量加数据
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰","张小四");
        System.out.println( list);
        //2. 打乱顺序
        Collections.shuffle(list);
        System.out.println(list);
        //3. 排序
        Collections.sort(list);//如果没有排序规则则要自定义规则
    }
}
