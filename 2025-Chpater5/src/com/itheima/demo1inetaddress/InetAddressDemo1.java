package com.itheima.demo1inetaddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) {
        //目标： 认识inetaddress过去本机IP对象和对方IP对象
        try {
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println(ip1);
            System.out.println(ip1.getHostName());
            System.out.println(ip1.getHostAddress());

            //2. 获取对方IP对象
            InetAddress ip2 = InetAddress.getByName("www.bilibili.com");
            System.out.println(ip2);
            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());

            //3. 判断本机与对方主机是否互通
            System.out.println(ip2.isReachable(5000));

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
