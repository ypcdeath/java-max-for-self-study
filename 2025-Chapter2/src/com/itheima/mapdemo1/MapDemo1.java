package com.itheima.mapdemo1;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        //目标： 了解键值对集合的特点
        Map<String,String> map = new HashMap<>(); //多态
        //无序 不重复 无索引
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        map.put("002","赵六");
        map.put("004","张三");
        System.out.println(map);
        //LinkedHashMap ：有序 不重复 无索引
        //TreeMap ：排序 不重复 无索引
    }
}
