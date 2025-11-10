package com.itheima.demo7FileWriter;

import java.io.FileWriter;

public class FileWriterDemo1 {
    public static void main(String[] args) {
        //创建文件字符输入流与源文件联通
        try(
                FileWriter fw = new FileWriter("2025-Chapter3/src/azicat7.txt");//覆盖管道
                FileWriter fw2 = new FileWriter("2025-Chapter3/src/azicat7.txt",true);//追加管道
        ){
            fw.write('a');
            fw.write(97);
            fw.write('晏');
            fw.write("\r\n");
            //写一个字符串
            fw.write("hello world");
            fw.write("我上早八");
            fw.write("\r\n");
            //写字符串的一部分
            fw.write("hello world",0,5);
            fw.write("\r\n");
            //写字符数组
            char[] chs = "java".toCharArray();
            fw.write(chs);
            fw.write("\r\n");
            //写字符数组一部分
            fw.write(chs,1,2);
            fw.write("\r\n");

            fw.flush();//刷新后流能继续使用 close 关闭了也会刷新但是不能继续刷新了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
