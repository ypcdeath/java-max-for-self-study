package com.itheima.thread.demo5lock;

public class Test {
    public static void main(String[] args) {
        //目标：线程同步的方式一 同步代码块
        JointCount jointCount1 = new JointCount("ypc123456",100000);

        new GetMoney("小明",100000,jointCount1).start();
        new GetMoney("小红",100000,jointCount1).start();
        //所以怎么解决呢？
        JointCount jointCount2 = new JointCount("yxq123456",200000);

        new GetMoney("小黑",100000,jointCount2).start();
        new GetMoney("小白",100000,jointCount2).start();
    }


}
