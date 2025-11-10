package com.itheima.demo13printstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStream {
    public static void main(String[] args) {
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\JavaCode\\JavaMax\\2025-Chapter3\\src\\azicat78.txt"));
                ){
            dos.writeByte(34);
            dos.writeInt(88);
            dos.writeLong(123456789L);
            dos.writeUTF("我上早八");
            dos.writeBoolean(true);
            dos.writeDouble(1.0);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
