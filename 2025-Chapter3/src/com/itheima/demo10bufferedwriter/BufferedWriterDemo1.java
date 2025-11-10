package com.itheima.demo10bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterDemo1 {
    public static void main(String[] args) {
        //创建文件字符输入流与源文件联通
        try(
//                FileWriter fw = new FileWriter("2025-Chapter3/src/azicat7.txt");//覆盖管道
                FileWriter fw = new FileWriter("2025-Chapter3/src/azicat7.txt",true);//追加管道
                BufferedWriter bw = new BufferedWriter(fw);
        ){
            bw.write('a');
            bw.write(97);
            bw.write('晏');
            bw.newLine();
            //写一个字符串
            bw.write("hello world");
            bw.write("我上早八");
            bw.newLine();
            //写字符串的一部分
            bw.write("hello world",0,5);
            bw.newLine();
            //写字符数组
            char[] chs = "java".toCharArray();
            bw.write(chs);
            bw.newLine();
            //写字符数组一部分
            bw.write(chs,1,2);
            bw.newLine();

            bw.flush();//刷新后流能继续使用 close 关闭了也会刷新但是不能继续刷新了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
