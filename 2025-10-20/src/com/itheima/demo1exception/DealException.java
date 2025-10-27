package com.itheima.demo1exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DealException {
    public static void main(String[] args) {
        //目标：掌握异常的处理方案1 底层异常都抛出去给外层调用者 最外层捕获异常，记录异常，响应信息
        try {
            show();
        } catch (Exception e) {
            System.out.println("出现异常了，请处理");
        }
    }

    public static void show() throws Exception {
        System.out.println("程序开始");
        String str = "2025-10-27 08:29:13";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date data = sdf.parse(str);//编译时异常
        System.out.println(data);
        System.out.println("程序结束");
        InputStream is = new FileInputStream("D:/dajiji.png");
    }
}
