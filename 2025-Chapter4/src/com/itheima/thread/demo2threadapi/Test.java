package com.itheima.thread.demo2threadapi;

public class Test {
    public static void main(String[] args) {
        Thread th1 = new MyThread("1号");
        th1.start();//启动必须调 start不能是run
        System.out.println(th1.getName());

        Thread th2 = new MyThread("2号");
        th2.start();
        System.out.println(th2.getName());

        Thread m = Thread.currentThread();//哪个线程调用它 就是哪个线程
        System.out.println(m.getName());//就叫main
    }
}

class MyThread extends Thread{
    MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
