package com.itheima.demo5tcp2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了...");
        //目标： 实现服务端一发一收
        //1. 创建服务器ServerSocket对象，绑定端口号，监听客户端连接
        ServerSocket ss = new ServerSocket(9999);
        //2. 调用accept方法,阻塞等待客户端连接,获取Socket对象，获取输入流，读取数据
        Socket socket = ss.accept();
        //3. 获取输入流 读取客户端发送的数据
        InputStream is = socket.getInputStream();
        //4. 包装成特殊数据输入流
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            //5. 读取数据
            String msg = dis.readUTF();//等待客户端发送的数据
            System.out.println("msg:"+msg);
            //6. 客户端的ip和端口(谁给我发的)
            System.out.println("[客户端的IP:" + socket.getInetAddress().getHostAddress() +
                   " 客户端的端口:"+ socket.getPort() +"]");
            System.out.println("================");
            //服务端不能关管道，服务端要一直运行，不能关闭，
        }

    }
}

