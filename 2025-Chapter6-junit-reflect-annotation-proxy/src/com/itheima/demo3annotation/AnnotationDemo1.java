package com.itheima.demo3annotation;

@MyBook(name = "明日香",age = 15, address = {"立本","德国","中国"})
@A("绫波丽")
public class AnnotationDemo1 {

    @MyBook(name = "渚薰",age = 16, address = {"月球","立本","香港"})
    public static void main(String[] args) {
        //目标： 自定义注解
    }
}
