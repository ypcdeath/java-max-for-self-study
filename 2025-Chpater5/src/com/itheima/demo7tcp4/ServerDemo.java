package com.itheima.demo7tcp4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动了...");
        //目标： BS架构的原理理解
        //1. 创建服务器ServerSocket对象，绑定端口号，监听客户端连接
        ServerSocket ss = new ServerSocket(8080);
        //2. 调用accept方法,阻塞等待客户端连接,获取Socket对象，获取输入流，读取数据
        ExecutorService pool = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        while (true) {
           Socket socket = ss.accept();
           //创建线程池
           pool.execute(new ServerReader(socket));

        }


    }
}

