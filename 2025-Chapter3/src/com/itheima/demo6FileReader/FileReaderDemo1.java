package com.itheima.demo6FileReader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        //创建文件字符输入流与源文件联通
        try (Reader fr = new FileReader("2025-Chapter3/src/azicat6.txt")) {
            char[] chs = new char[3];
            int len;
            while((len = fr.read(chs)) != -1 ){
                String str = new String(chs,0,len);
                System.out.print(str);
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}
