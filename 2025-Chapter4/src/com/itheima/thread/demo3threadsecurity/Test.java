package com.itheima.thread.demo3threadsecurity;

public class Test {
    public static void main(String[] args) {
        JointCount jointCount = new JointCount();
        jointCount.setCapital(100000);//先存10w

        new GetMoney("小明",100000,jointCount).start();
        new GetMoney("小红",100000,jointCount).start();
        //所以怎么解决呢？
    }


}
