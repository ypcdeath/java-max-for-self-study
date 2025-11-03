package com.itheima.mapdemo1;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        //目标: 认识treemap
        Map<Teacher,String> map = new TreeMap<>((o1,o2)->Double.compare(o1.getSalary(),o2.getSalary()));
        map.put(new Teacher("张三",23,5000),"402期");//再来4个数据
        map.put(new Teacher("王五",25,6000),"402期");
        map.put(new Teacher("赵六",26,3000),"403期");
        map.put(new Teacher("田七",27,8000),"401期");
        System.out.println(map);
    }
}
