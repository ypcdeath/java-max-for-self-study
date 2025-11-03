package com.itheima.mapdemo1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        //目标: 认识常见的mao操作
        Map<String,Integer> map = new HashMap<>();
        map.put("wtf",100);
        map.put("wth",200);
        map.put("aaa",300);
        map.put("bbb",400);
        map.put(null,null);
        System.out.println(map);
        System.out.println(map.get("wtf"));
        System.out.println(map.get("bbb"));

        System.out.println(map.containsKey("wtf"));
        System.out.println(map.containsValue(100));

        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.remove("wtf"));
//        map.clear();

        Set<String> keySet = map.keySet();
        Collection<Integer> values = map.values();

        for(String key : keySet){
            System.out.println(key + ":" + map.get(key));
        }
        for(Integer value : values){
            System.out.println(value);
        }
    }
}
