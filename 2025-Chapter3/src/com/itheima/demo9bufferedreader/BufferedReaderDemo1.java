package com.itheima.demo9bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        //创建文件字符输入流与源文件联通
        try (
                Reader fr = new FileReader("2025-Chapter3/src/azicat6.txt");
                //创建缓冲字符输入流包装
                BufferedReader br = new BufferedReader(fr);
        ) {
//            char[] chs = new char[3];
//            int len;
//            while((len = br.read(chs)) != -1 ){
//                String str = new String(chs,0,len);
//                System.out.print(str);
//            }
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}
