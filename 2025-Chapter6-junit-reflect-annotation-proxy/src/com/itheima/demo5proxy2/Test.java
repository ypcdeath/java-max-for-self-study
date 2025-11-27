package com.itheima.demo5proxy2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        UserService proxy = ProxyUtil2.createProxy(new UserServiceImp());
        proxy.login("admin","123456");
        proxy.deleteUsers();
        String[] names = proxy.selectUsers();
        System.out.println(Arrays.toString( names));
    }
}
