package com.itheima.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //目标： 添加Stream流的方式
        //1. 获取集合collection的Stream流
        List<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();;

        //2. Map集合的Stream流
        Map<String,Integer> map = new HashMap<>();
        Stream<String> s2 = map.keySet().stream();
        Stream<Integer> s3 = map.values().stream();
        Stream<Map.Entry<String,Integer>> s4 = map.entrySet().stream();

        //3. 数组获取Stream流
        String[] names = {"张三","李四","王五","赵六","田七"};
        Stream<String> s5 = Arrays.stream(names);
        System.out.println(s5.count());

        Stream<String> s6 = Stream.of(names);

        Stream<Integer> s7 = Stream.of(1,2,3,4,5,6,7,8,9,10);
    }
}
