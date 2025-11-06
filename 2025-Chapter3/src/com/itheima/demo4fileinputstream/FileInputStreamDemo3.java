package com.itheima.demo4fileinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo3 {
    public static void main(String[] args) throws Exception {
        //目标： 掌握文件字节输入流读取文件的字节数组到内存来
        //1. 创建文件字节输入流管道于源文件中
        InputStream is = new FileInputStream("2025-Chapter3\\src\\azicat2.txt");//简化写法
        //2. 定义一个变量记住每次读取的一个字节
        // 定义一个字节数组 记住每次读取的字节
        byte[] bytes = is.readAllBytes();
        //但是文件过大就不能一次性读完了 所以读文本用文件字符输入流好一些
        if(bytes != null){
            String str = new String(bytes);
            System.out.println(str);
        }
    }
}
