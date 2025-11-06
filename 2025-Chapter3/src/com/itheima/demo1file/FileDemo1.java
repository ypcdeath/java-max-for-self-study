package com.itheima.demo1file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //目标： 创建File类对象代表文件或者文件夹，搞清楚对文件操作的方法
        File file = new File("D:\\a.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        //相对路径
        File file1 = new File("2025-Chapter3/src/demo1.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.length());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());

        //创建对象代表不存在的文件
        File file2 = new File("D:\\a.txt");
        System.out.println(file2.exists());
        System.out.println(file2.createNewFile());

        //创建对象代表不存在的文件夹
        File file3 = new File("D:\\b");
        System.out.println(file3.exists());
        System.out.println(file3.mkdir());
        File file4 = new File("D:\\c\\dd\\ee");
        System.out.println(file4.exists());
        System.out.println(file4.mkdirs());
        //删除文件夹 只能删除空文件夹
        System.out.println(file4.delete());
        System.out.println(file3.delete());

        //文件遍历 一级文件
        File file5 = new File("D:/Downloads");
//        String[] names = file5.list();
//        for(String name : names){
//            System.out.println(name);
//        }
        File[] files = file5.listFiles();
        for(File f : files){
            System.out.println(f.getName());
        }

    }
}
