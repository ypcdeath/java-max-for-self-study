package com.itheima.demo1exception;

/**
 * 自定义异常类
 * 1.继承Exception类
 * 2.重写构造方法
 * 3.使用throw抛出异常对象
 */

public class AgeException extends Exception{
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
