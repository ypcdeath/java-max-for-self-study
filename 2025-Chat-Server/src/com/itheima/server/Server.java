package com.itheima.server;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Server {
    //定义一个集合 记住所有socket的客户端管道
    //map集合 socket管道对象 - 名字
    public static final Map<Socket,String> onLineSockets = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("启动服务端系统......");
        //1. 注册端口
        try {
            ServerSocket serverSocket = new ServerSocket(Constant.PORT);
            //主线程处理接受客户端连接请求
            while(true){
                //accept()方法会阻塞，直到有客户端连接 获取客户端管道对象
                System.out.println("等待客户端连接...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("一个客户端连接了");
                new ServerReader(clientSocket).start();

            }
        } catch (Exception e) {
            System.out.println("服务器启动失败");
        }

    }

    public static void updateOnlineList() {
        Collection<Socket> onLineUsers = Server.onLineSockets.keySet();
        for (Socket socket : onLineUsers) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(Constant.LOGIN);
                dos.writeInt(onLineUsers.size());
                for (Socket s : onLineUsers) {
                    if(s.equals( socket)) continue;
                    dos.writeUTF(Server.onLineSockets.get(s));
                }
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
