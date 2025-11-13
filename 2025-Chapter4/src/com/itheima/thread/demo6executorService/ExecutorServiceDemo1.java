package com.itheima.thread.demo6executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        //目标：创建线程池对象来使用
        //1. 使用线程池的实现类TreadPoolExecutor 声明七个阐述来创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //有几个正式员工 最大员工 临时的员工存活时间 单位 任务队列 创建工厂 拒绝方法

        //2. 使用线程池处理任务，是不是复用？
        Runnable target = new MyRunnable();
        pool.execute(target);//提交第一个任务
        pool.execute(target);//第二个
        pool.execute(target);//第三个
        pool.execute(target);//六个剩下的3个在队列里面 没满 所以不会创建临时线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);//第7个队列也进不去了 只能招临时线程了
        pool.execute(target);
        pool.execute(target);//任务队列也满了 临时线程也满了 忙不过来 就拒绝

        pool.shutdown();//pool.shutdownNow
        //什么时候创建临时线程 新任务提交的时候核心线程都在忙 任务队列也满了 并且有条件创建临时线程 才会创建临时线程
    }
}
