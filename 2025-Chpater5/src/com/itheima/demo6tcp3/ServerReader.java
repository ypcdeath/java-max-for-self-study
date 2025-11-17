package com.itheima.demo6tcp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //读取管道的信息
            //3. 获取输入流 读取客户端发送的数据
            InputStream is = socket.getInputStream();
            //4. 包装成特殊数据输入流
            DataInputStream dis = new DataInputStream(is);
            //5. 读取数据
            while (true) {
                String msg = dis.readUTF();//等待客户端发送的数据
                System.out.println("msg:"+msg);
                //6. 客户端的ip和端口(谁给我发的)
                System.out.println("[客户端的IP:" + socket.getInetAddress().getHostAddress() +
                        " 客户端的端口:"+ socket.getPort() +"]");
                System.out.println("================");
                //服务端不能关管道，服务端要一直运行，不能关闭，
            }
        } catch (IOException e) {
            System.out.println(socket.getInetAddress().getHostAddress() + "客户端断开连接");
        }
    }
}
