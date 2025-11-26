package com.itheima.demo3annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo2 {
    //目标：解析注解

    @Test
    public void ParseClass() throws Exception {
        //1. 获取类对象
        Class c1 = Demo.class;
        //2.判断这个类上是否注解了MyTest2
        if(c1.isAnnotationPresent(MyTest2.class)){
            //3. 获取注解对象
            MyTest2 myTest2 = (MyTest2)c1.getDeclaredAnnotation(MyTest2.class);
            //从这里开始=====================
            //4. 获取注解对象的属性值 你去看看MyTest2类有哪些属性
            String[] address = myTest2.address();
            double height = myTest2.height();
            String value = myTest2.value();

            //打印属性值
            System.out.println("address:"+ Arrays.toString( address));
            System.out.println("height:"+height);
            System.out.println("value:"+value);

        }
    }

    @Test
    public void ParseMethod() throws Exception {
        //1.获取类对象
        Class c1 = Demo.class;

        //2.获取方法对象
        Method m1 = c1.getMethod("go");
        //3.判断这个方法上是否有注解
        if(m1.isAnnotationPresent(MyTest2.class)){
            //4.获取注解对象
            MyTest2 myTest2 = m1.getDeclaredAnnotation(MyTest2.class); //方法可以识别类型
            //5.获取注解对象的属性值
            String[] address = myTest2.address();
            double height = myTest2.height();
            String value = myTest2.value();

            System.out.println("address:"+ Arrays.toString( address));
            System.out.println("height:"+height);
            System.out.println("value:"+value);
        }
    }
}
