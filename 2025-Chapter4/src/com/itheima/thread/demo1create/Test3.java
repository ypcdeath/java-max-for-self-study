package com.itheima.thread.demo1create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test3 {
    public static void main(String[] args) {
        //目标： 掌握线程创建的方法3 前两种只能执行任务 但是没有返回值给主线程
        //创建任务对象 定义一个类实现Callable接口 封装任务和要返回的数据
        //把Callable封装成FutureTask 未来任务对象
        //给Thread对象 start 然后  FutureTask对象的get方法可以获取Callable中call方法返回的数据
        Callable<String> c1 = new MyCallable(100);
//        Runnable f1 = new FutureTask<>(c1);//本质是一个runnable对象
        FutureTask<String> f1 = new FutureTask<>(c1);//本质是一个runnable对象
        Thread tr1 = new Thread(f1);
        tr1.start();

        Callable<String> c2 = new MyCallable(50);
//        Runnable f1 = new FutureTask<>(c1);//本质是一个runnable对象
        FutureTask<String> f2 = new FutureTask<>(c2);//本质是一个runnable对象
        Thread tr2 = new Thread(f2);
        tr2.start();

        try {
            System.out.println(f1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyCallable implements Callable<String> {
    public MyCallable(int n) {
        this.n = n;
    }
    private int n;
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= this.n; i++) {
            System.out.println("线程"+n+"：" + i);
            sum += i;
        }
        return "子线程的计算结果是："+sum + "为1到"+this.n;
    }
}
