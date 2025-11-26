package com.itheima.demo4proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    //中介公司，专门创建代理类
    //创建明星对象的代理对象返回
    public static StarService createProxy(Star star){
       StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
               star.getClass().getInterfaces(), new InvocationHandler() {
                   @Override
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       //参数1. proxy:代理对象
                       //参数2. method:被代理对象方法 正在被调用的方法
                        //参数3. args:被代理对象方法参数
                       if(method.getName().equals("sing")){
                           System.out.println("开始代理唱歌");
                           System.out.println("准备话筒，收钱20w！");
                       } else if (method.getName().equals("dance")){
                           System.out.println("开始代理跳舞");
                           System.out.println("准备舞台，收钱100w！");
                       }
                       //真正干活 找真正的明星对象来干活
                       Object result = method.invoke(star,args);
                       return result;
                   }
               });
       //参数一：类加载器 用于执行用哪个类加载器去加载成分的代理类
       //参数二：代理类需要实现的接口 （有多个接口需要用数组传递） 明星类实现了哪些接口，代理类就去实现哪些接口
       //参数三：代理类对象要如何去代理（代理要做的事）
       return proxy;
    }
}
