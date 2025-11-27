package com.itheima.demo5proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil2 {
    public static <T> T createProxy(T user){
        //创建代理对象
        T proxy = (T) Proxy.newProxyInstance(ProxyUtil2.class.getClassLoader(),
                user.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        Object result =  method.invoke(user,args);
                        long end = System.currentTimeMillis();
                        System.out.println(method.getName()+"方法耗时"+(end-start)/1000.0+"秒");
                        return result;
                    }
                });
        return proxy;
    }
}
