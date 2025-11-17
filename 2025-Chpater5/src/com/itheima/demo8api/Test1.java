package com.itheima.demo8api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //目标： 掌握java提供的获取时间的方案
        //jdk8 之前的方案 Date
        Date d = new Date();
        System.out.println(d);

        //格式化： SimpleDateFormat 简单日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format = sdf.format(d);
        System.out.println(format);

        //jdk8 之后的方案： LocalDate LocalTime LocalDateTime
        LocalDateTime now = LocalDateTime.now();//现在本地日期
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        //获取星期几
        System.out.println(now.getDayOfWeek().getValue());

        //格式化 DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format1 = dtf.format(now);
        System.out.println(format1);

    }
}
