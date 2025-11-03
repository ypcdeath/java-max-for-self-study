package com.itheima.mapdemo1;

import java.util.HashMap;
import java.util.Map;

public class MapTraverseDemo5 {
    public static void main(String[] args) {
        //目标： 遍历Map集合的元素 键找值
        Map<String,Integer> map = new HashMap<>();
        //造5个数据

        map.put("张三",23);
        map.put("王五",25);
        map.put("赵六",26);
        map.put("田七",27);
        map.put("小王",28);
        System.out.println(map);
        //1. forEach遍历
        map.forEach((k,v) -> System.out.println(k+"---"+v));
    }
}
