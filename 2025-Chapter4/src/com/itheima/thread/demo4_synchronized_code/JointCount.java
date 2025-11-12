package com.itheima.thread.demo4_synchronized_code;

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

    private final Lock lock = new ReentrantLock(true);

    public void drawMoney(double target) throws Exception {
        synchronized (this) { //但是这个类锁对象是唯一的，所以两个线程只能有一个线程进入这个方法，其他线程只能等待 所以不能用这个锁
            if(target > capital){//实例方法就用this 静态方法用字节码 类名.class
                throw new Exception();
            } else {
                System.out.println(id+"取钱成功"+"金额为"+target);
                capital -= target;
            }
        }
    }

    //同步方法就是 在返回类型前 加 synchronized 默认用this作为锁 静态方法用类名.class
    //3， 锁对象
}
