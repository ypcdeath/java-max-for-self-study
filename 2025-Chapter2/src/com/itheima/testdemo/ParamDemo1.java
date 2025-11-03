package com.itheima.testdemo;

public class ParamDemo1 {
    public static void main(String[] args) {
        sum();
        sum(10);
        sum(1,2,3,4,5);
        sum(new int[] {1,2,3,4,5});
    }

    public static int sum(int...a){
        //可变参数只能有一个 只能放在后面
        int sum = 0;
        for(int num :a){
            sum += num;
        }
        return sum;
    }
}
