package com.itheima.thread.demo4_synchronized_code;

public class GetMoney extends Thread{
    double targetMoney;
    JointCount jointCount;
    public GetMoney(String name, double targetMoney, JointCount jointCount){
        super(name);
        this.targetMoney = targetMoney;
        this.jointCount = jointCount;
    }
    @Override
    public void run() {
        System.out.println(this.getName() + "正在取钱");
        try {
            jointCount.drawMoney(targetMoney);
            System.out.println(this.getName() + "取钱后的余额为：" + jointCount.getCapital());
        } catch (Exception e) {
            System.out.println(this.getName()+"取钱失败,余额不足");
        }
    }
}
