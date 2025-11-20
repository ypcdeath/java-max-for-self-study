package com.itheima.demo3udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标： 完成UDP通信
        System.out.println("====客户端启动====");
        //1. 创建发送对象 代表抛包的人
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入信息:");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                socket.close();
                break;
            }
            //2. 创建数据，并把数据打包
            byte[] bytes = msg.getBytes();
            //字节打包 最多64kb 1.(数据)字节数组 2.字节长度 3.目标地址 4.目标端口
            packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8080);
            //3. 让发送端发送数据包的数据
            socket.send(packet);
        }

    }
}
