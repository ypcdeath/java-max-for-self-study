package com.itheima.thread.demo1create;

public class Test2_2 {
    public static void main(String[] args) {
        //目标： 掌握线程创建的方法2： 实现Runnable接口来创建
        Thread tr = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程1：" + i);
            }
        });//相当于把任务给这个线程
        tr.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + i);
        }
    }
}
