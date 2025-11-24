package com.itheima.demo3annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})// 表示注解的作用目标 方法和成员变量
@Retention(RetentionPolicy.RUNTIME) // 表示注解的保留策略 一直活 永远的在
public @interface MyTest {
}
