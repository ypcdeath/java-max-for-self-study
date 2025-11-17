package com.itheima.demo5tcp2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入信息:");
            String msg = sc.nextLine();
            if(msg.equals("exit")){
                //4. 关闭管道
                System.out.println("客户端退出...");
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}
