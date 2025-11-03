package com.itheima.testdemo;

import java.util.*;

public class Room {
    private List<Card> cards = new ArrayList<>();
    //实例代码块 创建对象时执行 初始化对象
    {
        //准备点数 和花色
        String nums[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String colors[] = {"♠","♥","♣","♦"};
        for(String num : nums){
            for(String color : colors){
                //创建牌对象 然后扔进集合中去
                cards.add(new Card(num,color));
            }
        }
        cards.add(new Card("","🃏"));//小王
        cards.add(new Card("","👲"));//大王
        System.out.println(cards);
    }

    public void start(){
        //洗牌
        Collections.shuffle(cards);
        System.out.println("洗牌后："+cards);
        //发牌 创建三个玩家： 令狐冲[] 令狐白[] 令狐黄[]
        Map<String,List<Card>> players = new HashMap<>();
        List<Card> lhc = new ArrayList<>();
        players.put("令狐冲",lhc);

        List<Card> lhb = new ArrayList<>();
        players.put("令狐白",lhb);

        List<Card> lhh = new ArrayList<>();
        players.put("令狐黄",lhh);

        for(int i = 0;i<cards.size()-3;i++){
            if(i%3==0){
                lhc.add(cards.get(i));
            } else if (i%3==1){
                lhb.add(cards.get(i));
            } else {
                lhh.add(cards.get(i));
            }
        }


        //拿三张底牌
        List<Card> lastCards = cards.subList(cards.size()-3,cards.size());

        //抢地主
        lhb.addAll(lastCards);

        //对牌排序


        //看牌
        for(Map.Entry<String,List<Card>> entry : players.entrySet()){
            String name = entry.getKey();
            List<Card> myCards = entry.getValue();
            System.out.println(name+ "的牌为:" +myCards);
        }

    }
}
