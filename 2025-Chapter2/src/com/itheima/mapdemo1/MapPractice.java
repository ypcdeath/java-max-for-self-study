package com.itheima.mapdemo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {
        //实战： 80个学生投票4个景点（A，B，C，D） 一个人只能投一次 看看哪个景点被投票最多
        Map<String,Integer> votes = new HashMap<>(){{
                put("A",0);
                put("B",0);
                put("C",0);
                put("D",0);
            }};
        List<String> sceneries = new ArrayList<>();
        String[] sceneriesArr = {"A","B","C","D"};
        for(int i = 0;i<80;i++){
            int index = (int)(Math.random()*4);
            sceneries.add(sceneriesArr[index]);
        }
        for(String scenery : sceneries){
            if(votes.containsKey(scenery)) {
                votes.put(scenery,votes.get(scenery)+1);
            }else{
                votes.put(scenery,1);
            }
        }
        vote(votes);
    }

    public static void vote(Map<String,Integer> votes){
        votes.forEach((k,v)->System.out.println(k+"被投票了"+v+"次"));
    }
}
