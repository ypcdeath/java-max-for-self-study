package com.itheima.thread.demo6executorService;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
    public MyCallable(int n) {
        this.n = n;
    }
    private int n;
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= this.n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "计算1到"+this.n + "的结果为"+sum;
    }
}
