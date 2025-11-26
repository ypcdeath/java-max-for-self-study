package com.itheima.demo4proxy;

public class Test {
    public static void main(String[] args) {
        //目标： 创建代理对象
        //1. 准备一个明星对象，设计明星类
        Star star = new Star("蔡徐坤");
        //2，为蔡徐坤创建一个专属的代理对象
        StarService proxy = ProxyUtil.createProxy(star);
        proxy.sing("基尼太美");
        System.out.println(proxy.dance("Dead Man"));
    }
}
