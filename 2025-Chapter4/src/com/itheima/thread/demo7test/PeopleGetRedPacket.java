package com.itheima.thread.demo7test;

import java.util.List;

public class PeopleGetRedPacket extends Thread{
    private List<Integer> redlist;
    public PeopleGetRedPacket(List<Integer> redlist, String name) {
        super(name);
        this.redlist = redlist;
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        //100个人来抢钱
        while (true) {
            synchronized (redlist){
                if(redlist.size() == 0){
                    break;
                }
                //随机一个索引取钱
                int index = (int)(Math.random() * redlist.size());
                int money = redlist.remove(index);
                System.out.println(name + "抢到：" + money);
                if(redlist.size() == 0) System.out.println("活动结束");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
