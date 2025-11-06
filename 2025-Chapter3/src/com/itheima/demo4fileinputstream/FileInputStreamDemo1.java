package com.itheima.demo4fileinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //目标： 掌握文件字节输入流读取文件的字节数组到内存来
        //1. 创建文件字节输入流管道于源文件中
        InputStream is = new FileInputStream("2025-Chapter3\\src\\azicat1.txt");//简化写法
        //2. 定义一个变量记住每次读取的一个字节
        int b;
        while((b = is.read()) != -1){
            System.out.print((char)b);
        }
        //每次读取一个字节 性能差 而且读不了汉字(3个字节)

    }
}
