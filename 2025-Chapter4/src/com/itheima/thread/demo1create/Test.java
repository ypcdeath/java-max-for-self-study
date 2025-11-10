package com.itheima.thread.demo1create;

public class Test {
    public static void main(String[] args) {
        Thread th = new MyThread();
        th.start();//启动必须调 start不能是run
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程：" + i);
        }
    }
}
