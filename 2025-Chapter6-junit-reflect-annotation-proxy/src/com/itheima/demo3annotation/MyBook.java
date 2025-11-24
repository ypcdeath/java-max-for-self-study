package com.itheima.demo3annotation;

//自定义注解
public @interface MyBook {
    String name();
    int age() default 18;
    String[] address();

    //注解本质是一个接口 里面是抽象方法

}
