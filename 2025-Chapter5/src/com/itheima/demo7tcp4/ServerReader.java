package com.itheima.demo7tcp4;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 给当前对应浏览器管道响应一个网页数据
            OutputStream os = socket.getOutputStream();
            //HTTP协议规定的网页数据格式
            //把字节输出流 包装成打印流
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();// 必须换一行
            ps.println("<html>");
            ps.println("<head><title>响应结果</title></head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size=20px'>服务器响应成功</h1>");
            ps.println("<img src=https://i0.hdslb.com/bfs/archive/ac7edcb6a0cd83bc3a7a7a0a3730ba69c17f47ab.png>");
            ps.println("</body>");
            ps.println("</html>");
            ps.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(socket.getInetAddress().getHostAddress() + "客户端断开连接");
        }
    }
}
