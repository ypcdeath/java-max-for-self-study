package com.itheima.demo2reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    @Test
    public void getClassInfo() {
        //目标：获取类的信息
        //1. 反射第一步: 获取class类，代表拿到类
        Class c1 = Student.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        //2. 获取类的构造器对象，并对其操作
    }

    @Test
    public void getConstructor() throws Exception {
        //目标：获取构造器对象
        Class c1 = Dog.class;
        //1. 获取所有构造器对象
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor con : constructors) {
            System.out.println(con.getName() + "(" + con.getParameterCount() + ")");
        }
        //获取单个构造器
        Constructor con1 = c1.getDeclaredConstructor();
        System.out.println(con1.getName() + "(" + con1.getParameterCount() + ")");

        Constructor con2 = c1.getDeclaredConstructor(String.class);
        System.out.println(con2.getName() + "(" + con2.getParameterCount() + ")");

        Constructor con3 = c1.getDeclaredConstructor(String.class, int.class);
        System.out.println(con3.getName() + "(" + con3.getParameterCount() + ")");

        //获取构造器对象的作用
        //暴力反射：暴力打开所有属性，暴力打开所有方法 就是可以访问私有的方法和属性
        con3.setAccessible(true);
        Dog dog = (Dog) con3.newInstance("张三", 10);


    }

    @Test
    public void getFieldInfo() throws Exception {
        //目标：获取属性信息
        Class c1 = Dog.class;
        //1. 获取所有属性对象
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ":" + field.getType());
        }

        //2. 获取单个属性对象
        Field field = c1.getDeclaredField("name");
        System.out.println(field.getName() + ":" + field.getType());

        Field field1 = c1.getDeclaredField("age");
        System.out.println(field1.getName() + ":" + field1.getType());

        Field field2 = c1.getDeclaredField("hobby");
        System.out.println(field2.getName() + ":" + field2.getType());

        //获取成员变量对象的目的
        Dog d = new Dog();
        //暴力反射
        field2.setAccessible(true);
        field2.set(d,"吃鸡吧");
        System.out.println(d);

        String hobby = (String) field2.get(d);
        System.out.println(hobby);

    }

    @Test
    public void getMethodInfo() throws Exception {
        //目标：获取方法信息
        Class c1 = Dog.class;
        //1. 获取所有方法对象
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "(" + method.getParameterCount() + ")");
        }

        //2. 获取单个方法对象
        Method method = c1.getDeclaredMethod("getName");

        Dog d = new Dog();
        Method m1 = c1.getDeclaredMethod("eat");
        Object invoke1 = m1.invoke(d);
        System.out.println(invoke1);

        Method m2 = c1.getDeclaredMethod("eat",String.class);
        Object invoke2 = m2.invoke(d,"急吧");
        System.out.println(invoke2);
    }

}
