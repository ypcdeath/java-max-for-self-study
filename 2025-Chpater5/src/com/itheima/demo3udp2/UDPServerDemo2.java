package com.itheima.demo3udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerDemo2 {
    public static void main(String[] args) throws Exception {
        //目标： 完成UDP 通信 一发一收 服务端开发
        System.out.println("====服务端启动====");
        //1. 创建接收端对象 创建端口8080
        DatagramSocket socket =  new DatagramSocket(8080);

        while (true) {
            //2. 创建数据包对象  作为接收数据的容器
            byte[] buf = new byte[1024*64];
            DatagramPacket packet = new DatagramPacket(buf,buf.length);
            //3. 接受数据
            socket.receive(packet);
            //4. 获取数据 看看是否收到了数据
            //获取当前收到的数据长度
            String data = new String(buf,0,packet.getLength());
            System.out.println(data);

            //获取对方IP对象 和程序端口
            InetAddress ip = packet.getAddress();
            int port = packet.getPort();
            System.out.println("["+"对方IP:"+ip.getHostAddress()+" 端口:"+port+"]");
        }
    }
}
