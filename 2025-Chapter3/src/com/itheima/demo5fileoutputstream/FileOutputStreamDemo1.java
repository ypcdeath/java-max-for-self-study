package com.itheima.demo5fileoutputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //目标： 学会使用文件字节输出流
        //1. 创建文件字节输出流管道
        OutputStream os = new FileOutputStream("2025-Chapter3/src/azicat3.txt",true);//覆盖管道
        //2. 写入字节
        os.write(97);
        os.write('b');
        os.write('晏');

        //3. 写一个字节数组

        byte[] bytes = "我爱你中国666".getBytes();
        os.write("\r\n".getBytes());
        os.write( bytes,0,3);

        os.close();//关闭管道
    }
}
