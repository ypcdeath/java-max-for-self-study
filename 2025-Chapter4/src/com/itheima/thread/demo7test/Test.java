package com.itheima.thread.demo7test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //目标：完成多线程小程序的开发
        //公司准备红包200个
        //有100员工，工号依次是1，2，3，4，，，100
        //200红包 小红包在[1-30]元 占80% 大红包[31-100]之间 占20%

        //1. 生成红List
        List<Integer> redlist = getRedPackets();
        //2.定义线程类，创建100个员工线程，竞争同一个集合，抢红包
        for(int i = 0;i<100;i++){
            new PeopleGetRedPacket(redlist,"员工"+(i+1)).start();
        }
    }

    //准备200个红包并返回，放到List集合里去
    public static List<Integer> getRedPackets(){
        //200红包 小红包在[1-30]元 占80% 大红包[31-100]之间 占20%
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            if(i <= 160){
                list.add((int)(Math.random()*30+1));
            }else{
                list.add((int)(Math.random()*70+31));
            }
        }
        return list;
    }
}
