package com.itheima.demo2reflect;


import lombok.Data;

@Data

public class Dog {
    private String name;
    private int age;
    private String hobby;
    public Dog(){
        System.out.println("无参构造方法");
    }

    private Dog(String name,int age){
        System.out.println("两个有参构造方法");
        this.name = name;
        this.age = age;
    }

    private Dog(String name){
        System.out.println("一个有参构造方法");
        this.name = name;
    }

    public void eat(){
        System.out.println("吃吃吃吃吃");
    }

    public String eat(String food){
        System.out.println("吃" + food);
        return "吃" + food;
    }
}
