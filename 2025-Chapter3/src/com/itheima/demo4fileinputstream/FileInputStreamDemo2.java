package com.itheima.demo4fileinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        //目标： 掌握文件字节输入流读取文件的字节数组到内存来
        //1. 创建文件字节输入流管道于源文件中
        InputStream is = new FileInputStream("2025-Chapter3\\src\\azicat1.txt");//简化写法
        //2. 定义一个变量记住每次读取的一个字节
        // 定义一个字节数组 记住每次读取的字节
        byte[] buffer = new byte[3];
        //定义一个变量 记住每次读了几个字节
        int len;
        while((len = is.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        //还是无法避免读汉字乱码的问题 会把汉字字节截断
        //那就用一个桶把 所有东西读完
    }
}
