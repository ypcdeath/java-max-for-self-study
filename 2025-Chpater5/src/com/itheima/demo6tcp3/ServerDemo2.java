package com.itheima.demo6tcp3;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了...");
        //目标： 实现服务端一发一收
        //1. 创建服务器ServerSocket对象，绑定端口号，监听客户端连接
        ServerSocket ss = new ServerSocket(9999);
        //2. 调用accept方法,阻塞等待客户端连接,获取Socket对象，获取输入流，读取数据
        while (true) {
           Socket socket = ss.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "客户端已上线");
           new ServerReader(socket).start();
        }


    }
}

