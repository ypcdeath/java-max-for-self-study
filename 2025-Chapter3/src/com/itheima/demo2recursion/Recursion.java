package com.itheima.demo2recursion;

import java.io.File;
import java.io.IOException;

public class Recursion {
    public static void main(String[] args) {
        //找 app.asar 文件搜索
        File dir = new File("D:/");
        //抽象成方法
        try {
            findFile(dir,"WeChat.exe");
        } catch (IOException e) {
            System.out.println("找不到文件");
        }

    }

    public static void findFile(File dir,String fileName) throws IOException {
        //1. 输入合法判断
        if(dir == null || !dir.exists() || dir.isFile()) return;

        File[] files = dir.listFiles();//获取所有一级文件夹
        //判断是否存在一级文件对象
        if(files != null && files.length > 0){
            for(File file : files){
                if(file.isFile() && file.getName().contains(fileName)){
                    System.out.println("找到目标文件:"+file.getName() + " 路径为:"+file.getAbsolutePath());
                    Runtime run = Runtime.getRuntime();
                    run.exec(file.getAbsolutePath());
                }else if(file.isDirectory()){
                    findFile(file,fileName);
                }
            }
        }
    }
}
