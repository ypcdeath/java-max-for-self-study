package com.itheima.demo10Bufferpractice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PracticeDemo1 {
    public static void main(String[] args) {
        //目标： 排序打乱的文章
        List<String> list = new ArrayList<>();
        list = to_List("2025-Chapter3/src/azicat8.txt");
        if(list == null) return;
        list.sort((o1, o2) -> o1.charAt(0) - o2.charAt(0));
        try(
                Writer fw = new FileWriter("2025-Chapter3/src/azicat10.txt");
                BufferedWriter bw = new BufferedWriter(fw);
        ){
            for(String line : list){
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> to_List(String srcPath){
        List<String> list = new ArrayList<>();
        try(
                FileReader fr = new FileReader(srcPath);
                BufferedReader br = new BufferedReader(fr);
        ){
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
