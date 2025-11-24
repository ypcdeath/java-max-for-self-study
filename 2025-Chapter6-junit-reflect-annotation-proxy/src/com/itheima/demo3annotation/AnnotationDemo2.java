package com.itheima.demo3annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationDemo2 {
    //目标：解析注解

    @Test
    public void ParseClass() throws Exception {
        //1. 获取类对象
        Class c1 = Demo.class;
        //2.判断这个类上是否注解了MyTest2
        if(c1.isAnnotationPresent(MyTest2.class)){
            //3. 获取注解对象
            Annotation myTest2 = c1.getDeclaredAnnotation(MyTest2.class);
            //从这里开始=====================
        }
    }
}
