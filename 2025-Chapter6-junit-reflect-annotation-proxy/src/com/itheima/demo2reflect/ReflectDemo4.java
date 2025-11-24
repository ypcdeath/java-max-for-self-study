package com.itheima.demo2reflect;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //目标： 反射的应用-- 做框架的通用技术
        Student s = new Student("张三", 18,"动漫");
        SaveObjectFrame.saveObject(s);
        Dog d = new Dog("小白", 4,"吃shi");
        SaveObjectFrame.saveObject(d);
        //创建老师对象使用全参构造器
        Teacher t = new Teacher("小王",20,"小说",8000.0,"高三3班",'女',"123456789");
        SaveObjectFrame.saveObject(t);


    }
}
