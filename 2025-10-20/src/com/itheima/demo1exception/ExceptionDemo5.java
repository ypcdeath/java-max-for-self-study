package com.itheima.demo1exception;

import java.util.Scanner;

public class ExceptionDemo5 {
    public static void main(String[] args) {
        //捕获异常对象，尝试重新修复
        //接受一个定价

        while (true) {
            try {
                double  price = 0;//不一定输入的是小数 需要捕获异常
                price = userInputPrice();
                System.out.println("价格是："+price);
                break;
            } catch (Exception e) {
                System.out.println("价格输入异常，请重新输入！");
            }
        }
        System.out.println("程序结束运行");
    }

    public static double userInputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        return price;
    }
}
