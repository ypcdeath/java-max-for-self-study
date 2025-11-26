package com.itheima.demo3annotation;

import java.lang.reflect.Method;

public class AnnotationDemo3 {
    public static void main(String[] args) {
        //目标： 认识到注解的作用和应用 注解就是特殊标记 特殊处理
        //模拟Junit
        //有MyTest3的方法就执行，没有的不执行
        //创建一个对象
        AnnotationDemo3 demo = new AnnotationDemo3();
        //获取类对象
        Class c1 = AnnotationDemo3.class;
        //获取所有方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            //判断方法上是否有MyTest3注解
            if(method.isAnnotationPresent(MyTest3.class)){
                //获取注解对象的属性值
                MyTest3 myTest3 = method.getDeclaredAnnotation(MyTest3.class);
                int count = myTest3.count();
                for (int i = 0; i < count; i++) {
                    //执行方法
                    try {
                        method.invoke(demo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        }


    }
    @MyTest3(count = 5)
    public void test1(){
        System.out.println("test1方法执行了");
    }

    public void test2(){
        System.out.println("test2方法执行了");
    }
    @MyTest3
    public void test3(){
        System.out.println("test3方法执行了");
    }

    public void test4(){
        System.out.println("test4方法执行了");
    }
}
