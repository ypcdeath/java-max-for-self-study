package com.itheima.demo13printstream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataStream2 {
    public static void main(String[] args) {
        try(
                DataInputStream dis = new DataInputStream(new FileInputStream("D:\\JavaCode\\JavaMax\\2025-Chapter3\\src\\azicat78.txt"));
                ){
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readLong());
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
