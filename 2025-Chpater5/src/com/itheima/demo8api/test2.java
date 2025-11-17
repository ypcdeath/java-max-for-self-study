package com.itheima.demo8api;

public class test2 {
    public static void main(String[] args) {
        //目标：高效拼接字符串
        String s = "abc";
        StringBuilder sb = new StringBuilder(s);
        //拼接过程使用：append
        //但是线程不安全 只能单线程使用
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
