package com.itheima.server;

import java.io.DataInputStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //接收消息： 1.登录消息 2.群聊消息 3.私聊消息
            //比如客户端先发1 表示登录消息
            //比如客户端先发2 表示群聊消息
            //比如客户端先发3 表示私聊消息
            //先接受消息类型编号
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int type = dis.readInt();
            switch (type) {
                case Constant.LOGIN:
                    //登录消息 接收昵称 再更新全部在线客户端的在线人数列表
                    String nickname = dis.readUTF();
                    Server.onLineSockets.put(socket,nickname);
                    Server.updateOnlineList();
                    break;
                case Constant.GROUP_CHAT:
                    //群聊消息 接收内容 再把内容发送给全部在线客户端
                    String content = dis.readUTF();
                    System.out.println(content);
                    break;
                case Constant.PRIVATE_CHAT:
                    //私聊消息 接收内容 接收目标昵称 再把内容发送给目标昵称对应的客户端
                    String from = dis.readUTF();
                    break;
             }

        } catch ( Exception e) {
            System.out.println(socket.getInetAddress().getHostAddress() + "客户端断开连接");
            Server.onLineSockets.remove(socket);
        }
    }



}
