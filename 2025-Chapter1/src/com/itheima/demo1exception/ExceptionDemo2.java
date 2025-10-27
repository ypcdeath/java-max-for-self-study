package com.itheima.demo1exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println("程序开始运行");
        try {
            System.out.println(div(10, 0));
            System.out.println("底层方法执行成功了!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常了，请处理");
        }
        System.out.println("程序结束运行");
    }

    public static int div(int a, int b) throws Exception{
        if(b == 0){
            System.out.println("除数不能为0");
//            return;
            //可以返回一个异常，让调用者处理，还能告知上层底层时执行成功了还是失败了
            throw new Exception("除数不能为0，您的参数有问题");
        }
        int result = a / b;
        return result;
    }
}
