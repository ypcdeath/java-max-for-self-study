package com.itheima.demo1exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args){
        //目标: 认识异常的体系，搞清楚一场的基本作用
        try{
            show2();
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public static void show() {
        //运行时异常的特点，编译阶段不报错，运行阶段时出现的异常，继承RuntimeException
        int[] arr = {10, 20, 30};
//        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
//        System.out.println(10/0);//ArithmeticException
        String str = "abc";
        str = null;
        System.out.println(str.length());//NullPointerException
    }

    //编译时异常
    public static void show2() throws ParseException {
        //编译阶段报错，编译就不通过
        String str = "2024-07-09 11:12:13";
        //把字符串转换成日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str); //提醒程序员这里的程序很容易出错，出bug，请你注意
        //把异常往外抛，表示你不要管这个异常
        System.out.println(date);
    }
}
