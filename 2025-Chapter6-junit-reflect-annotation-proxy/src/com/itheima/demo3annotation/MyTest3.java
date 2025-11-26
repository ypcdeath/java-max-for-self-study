package com.itheima.demo3annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//只能注解方法
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //注解保留策略: 运行时
public @interface MyTest3 {
    int count() default 1;
}
