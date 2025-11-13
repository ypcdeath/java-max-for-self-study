package com.itheima.thread.demo5lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JointCount {
    private String id;
    private double capital;

    private final Lock lock = new ReentrantLock();//当作常量 防止被撬

    public void drawMoney(double target) throws Exception {
            lock.lock();
        try {
            if(target > capital){//实例方法就用this 静态方法用字节码 类名.class
                throw new Exception();
            } else {
                System.out.println(id+"取钱成功"+"金额为"+target);
                capital -= target;
            }
        } finally {
            lock.unlock();//防止有异常也能解锁
        }

    }

    //同步方法就是 在返回类型前 加 synchronized 默认用this作为锁 静态方法用类名.class
    //3， 锁对象
}
