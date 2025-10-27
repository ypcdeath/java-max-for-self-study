package com.itheima.demo1exception;

public class ExceptionDemo3 {
    //自定义异常
    public static void main(String[] args) {
        //认识自定义异常
        try {
            saveAge(100);
            System.out.println("成功了！");
        } catch (AgeException e) {
            e.printStackTrace();
            System.out.println("出现异常了，请处理");
        }
    }

    //创建一个自定义异常类 年龄在1-200岁的范围内就是正常的，否则就是异常
    public static  void saveAge(int age) throws AgeException{
        if(age<1 || age>200){
            //不建议使用编译时异常，一层层抛太麻烦 自动会抛运行时异常
            //年龄非法，抛出去一个自定义异常
            AgeException ae = new AgeException("年龄非法！");
            //抛出异常对象
            throw ae;
        } else {
            System.out.println("年龄正常");
        }
    }

}
