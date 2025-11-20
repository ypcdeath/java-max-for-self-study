package com.itheima.demo1junit;

public class StringUtil {
    public static void printNumber(String name) {
        if(name == null){
            System.out.println("name为null");
            return;
        }
        System.out.println("名字的长度是:"+ name.length());
    }

    //求字符串的最大索引
    public static int getMaxIndex(String data) {
        if(data == null || "".equals(data)){
            return -1;
        }
        return data.length() - 1;
    }
}
