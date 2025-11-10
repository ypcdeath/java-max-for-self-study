package com.itheima.IOPractice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class IOPractice {
    private static final String PATH = "2025-Chapter3/src/count.txt";
    public static void main(String[] args) {
        //写一个程序 读取存档文件的数字 跟当前给的数字比较 如果大于的话 就保存
        int lastScore = 0;
        lastScore = getScore(PATH);
        int score;
        System.out.println("请输入你的分数：");
        Scanner sc = new Scanner(System.in);
        score = sc.nextInt();
        if (score > lastScore) {
            saveScore(PATH,score);
            System.out.println("你的分数比历史最高分高");
        } else {
            System.out.println("你的分数没有历史最高分高");
        }
        System.out.println("你的分数是：" + score + "历史最高分为" + lastScore);
    }

    public static int getScore(String Path){
        int lastScore = 0;
        try(
                DataInputStream fis = new DataInputStream( new FileInputStream(Path));
        ){
            lastScore = fis.readInt();
        } catch (Exception e){
            try (
                    DataOutputStream fis = new DataOutputStream(new FileOutputStream(Path))
            ) {
                fis.writeInt(0);
            } catch (Exception e1){
                e1.printStackTrace();
            }

        }
        return lastScore;
    }

    public static void saveScore(String Path,int score){
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(Path));
        ){
            dos.writeInt(score);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
