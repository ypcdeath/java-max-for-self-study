package com.itheima.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        //目标： 掌握stream流的统计收集操作(终结方法)
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher("张三",23,5000));
        list.add(new Teacher("王五",25,6000));
        list.add(new Teacher("赵六",26,3000));
        list.add(new Teacher("田七",27,8000));
        list.add(new Teacher("小王",28,9000));

        list.stream().filter(t -> t.getSalary() > 5000).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        long count = list.stream().filter(t -> t.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println("-------------------------------------------");
        Optional<Teacher> max = list.stream().max(Comparator.comparingDouble(Teacher::getSalary));
        Teacher maxTeacher = max.get();
        System.out.println(maxTeacher);
        //收集Stream流
        System.out.println("-------------------------------------------");
        List<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("周芷若");
        list1.add("赵敏");
        list1.add("张强");
        list1.add("张三丰");
        list1.add("张三丰");
        list1.add("张小四");
        Stream<String> s = list1.stream().filter(name -> name.startsWith("张"));
        List<String> list2 = s.collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("-------------------------------------------");
//        Set<String> list3 = s.collect(Collectors.toSet()); //流只能终结一次
        Set<String> set = new HashSet<>();
        set.addAll(list2);
        System.out.println(set);
        System.out.println("-------------------------------------------");
        Stream<Teacher> s1 = list.stream().sorted((t1,t2)-> Double.compare(t2.getSalary(),t1.getSalary()));
        //收集到Map集合：键是老师名称，值是老师对象
        Map<String,Teacher> map = list.stream().collect(Collectors.toMap(Teacher::getName, t -> t));
        System.out.println(map);


    }
}
