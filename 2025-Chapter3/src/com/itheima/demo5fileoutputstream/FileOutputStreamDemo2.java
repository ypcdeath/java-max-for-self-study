package com.itheima.demo5fileoutputstream;

import java.io.*;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        //目标： 学会使用字节管道来复制文件
        //原文件 2025-Chapter3/src/miao.jpg
        //目标文件 2025-Chapter3/src/miao_copy.jpg
        copyFile("2025-Chapter3/src/miao.jpg","2025-Chapter3/src/miao_copy.jpg");

    }

    //复制文件
    public static void copyFile(String srcPath,String destPath) throws Exception{
        try(InputStream fis = new FileInputStream(srcPath);//这个用来读文件 原 -> 输入管道
            OutputStream fos = new FileOutputStream(destPath);//这个用来写文件 输入管道 -> 输出管道 -> 目标文件
            ) {

            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read( bytes)) != -1){
                fos.write(bytes,0,len);
            }
            System.out.println("复制完毕");

        } catch (IOException e) {
            System.out.println("复制失败");;
        }

        //什么是资源呢 实现了AutoCloseable接口的类
    }
}
