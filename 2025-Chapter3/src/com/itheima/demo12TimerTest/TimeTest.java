package com.itheima.demo12TimerTest;

public class TimeTest {
    public static void main(String[] args) throws Exception {
        timeTest();
    }

    public static void timeTest() throws Exception {
        //获取当前时间戳
        long start = System.currentTimeMillis();
        Thread.sleep(100);
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000 + 's');
    }


}
