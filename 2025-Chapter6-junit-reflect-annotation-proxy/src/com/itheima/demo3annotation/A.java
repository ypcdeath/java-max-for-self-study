package com.itheima.demo3annotation;

public @interface A {
    String value();//特殊属性：在使用时如果只有一个value属性。value名称可以不写
    int age() default 18;//如果属性有默认值可以不写 当只有一个value要写可以不写value的名字

}
