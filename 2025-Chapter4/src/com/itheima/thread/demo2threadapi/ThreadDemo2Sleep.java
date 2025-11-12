package com.itheima.thread.demo2threadapi;

public class ThreadDemo2Sleep {
    public static void main(String[] args) {
        //目标： 搞清楚Thread的sleep方法
        for (int i = 0; i < 5; i++) {
            System.out.println("线程1：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
