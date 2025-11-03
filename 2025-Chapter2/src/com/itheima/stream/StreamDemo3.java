package com.itheima.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //目标： 拿去Stream流常用的中间方法，对流上的数据进行处理
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张小四");

        //1. 过滤方法
        list.stream().filter(name -> name.startsWith("张") && name.length() == 3).forEach(System.out::println);

        //2. 排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(99.9);
        scores.add(66.6);
        scores.add(77.7);
        scores.add(88.8);
        scores.add(88.8);
        scores.add(55.5);

        scores.stream().sorted().forEach(System.out::println);//默认是升序
        System.out.println("---------------------------------------------");
        scores.stream().sorted((s1,s2) -> Double.compare(s2,s1)).limit(2).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        scores.stream().sorted((s1,s2) -> Double.compare(s2,s1)).skip(2).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        scores.stream().sorted((s1,s2) -> Double.compare(s2,s1)).distinct().forEach(System.out::println);
        //如果希望自定义对象能够去重复 重写对象的hashcode和equals方法需要重写
        System.out.println("---------------------------------------------");
        scores.stream().map(s -> "加10分后成绩为" + (s+10)).forEach(System.out::println);

        Stream<String> s1 = Stream.of( "张三丰", "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张小四");
        Stream<Integer> s2 = Stream.of(111,222,333,444,555,666);
        Stream<Object> s3 = Stream.concat(s1,s2);

    }
}
