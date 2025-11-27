package com.itheima.demo5proxy2;

public class UserServiceImp implements UserService{
    @Override
    public void login(String username, String password) throws Exception {
        System.out.println("用户登录");
        Thread.sleep(1000);
    }

    @Override
    public void deleteUsers() throws Exception {
        System.out.println("正在删除用户");
        Thread.sleep(1500);
    }

    @Override
    public String[] selectUsers() throws Exception {
        System.out.println("正在查询用户");
        System.out.println("查询了3个用户");
        String[] names = {"张三","李四","王五"};
        Thread.sleep(2000);
        return names;
    }


}
