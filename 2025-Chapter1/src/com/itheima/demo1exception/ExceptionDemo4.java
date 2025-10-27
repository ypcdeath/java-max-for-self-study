package com.itheima.demo1exception;

public class ExceptionDemo4 {
    //自定义异常
    public static void main(String[] args) {
        //认识自定义异常
        saveAge2(300);
        System.out.println("程序结束运行");
    }

    //创建一个自定义异常类 年龄在1-200岁的范围内就是正常的，否则就是异常

    public static void saveAge2(int age){
        if(age<1 || age>200){
            AgeRuntimeException are = new AgeRuntimeException("年龄非法！");
            throw are;
        } else {
            System.out.println("年龄正常");
            System.out.println("保存年龄"+ age);
        }
    }
}
