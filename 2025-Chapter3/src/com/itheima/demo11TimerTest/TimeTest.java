package com.itheima.demo11TimerTest;

public class TimeTest {
    public static void main(String[] args) {

    }

    public TimeTest() throws InterruptedException {
        //获取当前时间戳
        long start = System.currentTimeMillis();
        Thread.sleep(100);
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000 + 's');
    }


}
