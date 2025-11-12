package com.itheima.thread.demo2threadapi;

public class ThreadAPIDemo3 {
    public static void main(String[] args) {
        //目标： 搞清楚join方法：让线程执行完再执行 线程插队
        Thread t = new MyThread2();
        t.start();
        for(int i = 0;i < 5;i++){
            System.out.println(Thread.currentThread().getName() + "主线程输出：" + i);
            if(i == 1){
                try {
                    t.join();//插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "子线程输出：" + i);
        }
    }
}
