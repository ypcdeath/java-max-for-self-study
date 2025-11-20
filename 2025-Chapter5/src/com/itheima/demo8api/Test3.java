package com.itheima.demo8api;

import java.math.BigDecimal;

public class Test3 {
    public static void main(String[] args) {
        //目标：解决小数运算失真的问题

        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);
        //如何解决呢？
        //把小数包装成 BigDecimal 对象运算
        BigDecimal a1 = new BigDecimal("0.1");
        BigDecimal a2 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal("0.2");
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        //但是可以使用 BigDecimal.valueOf()
        BigDecimal c1 = BigDecimal.valueOf(0.1);
        BigDecimal c2 = BigDecimal.valueOf(0.2);
        double c3 = c1.add(c2).doubleValue();
        System.out.println(c3);
        //注意除法循环小数
        BigDecimal d1 = new BigDecimal("0.1");
        BigDecimal d2 = new BigDecimal("0.2");
        BigDecimal d3 = d1.divide(d2,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(d3);
    }
}
