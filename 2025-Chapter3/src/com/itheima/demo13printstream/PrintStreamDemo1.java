package com.itheima.demo13printstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        //目标：打印流的使用
        try(
                PrintStream ps = new PrintStream(new FileOutputStream("D:\\JavaCode\\JavaMax\\2025-Chapter3\\src\\azicat78.txt",true));
        ){
            ps.println(97);
            ps.println("abc");
            ps.println('m');
            ps.println(true);
            ps.println(1.0);
            ps.println(123456789);
            ps.println(123456789L);
            ps.println("™");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
