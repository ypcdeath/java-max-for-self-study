package com.itheima.thread.demo6executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        //目标：创建线程池对象来使用
        //1. 使用线程池的实现类TreadPoolExecutor 声明七个阐述来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //有几个正式员工 最大员工 临时的员工存活时间 单位 任务队列 创建工厂 拒绝方法

        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();//pool.shutdownNow
        //什么时候创建临时线程 新任务提交的时候核心线程都在忙 任务队列也满了 并且有条件创建临时线程 才会创建临时线程
    }
}
