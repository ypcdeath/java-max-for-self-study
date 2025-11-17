package com.itheima.demo4tcp1;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CilentDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动...");
        //目标： 实现TCP通信 一发一收，客户端开发
        //1. 常见的Socket管道对象，请求与服务器的Socket链接。 可靠链接
        Socket socket = new Socket("127.0.0.1",9999);

        //2. 从Socket通信管道中得到一个字节输出流
        OutputStream os = socket.getOutputStream();//客户端 -> 服务端

        //3. 怎么发怎么收 特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeUTF("我喜欢你");

        //4. 关闭管道
        dos.close();
    }
}
