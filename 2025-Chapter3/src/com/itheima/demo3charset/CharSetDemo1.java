package com.itheima.demo3charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //目标： 写程序实现字符编码和解码
        //1. 编码
        String name = "我爱你中国abc666";

        byte[] bytes = name.getBytes("GBK");//平台的字符集
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        for(int i = 0;i < bytes.length;i++){
            bytes[i] = (byte)(bytes[i] + 1);
        }

        String name2 = new String(bytes,"GBK");
        System.out.println(name2);
    }
}
