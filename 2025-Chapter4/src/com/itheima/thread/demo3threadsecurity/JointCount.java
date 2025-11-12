package com.itheima.thread.demo3threadsecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JointCount {
    private double capital;

    public void drawMoney(double target){
        if(target > capital){
            System.out.println("取钱失败");
        } else {
            System.out.println("取钱成功"+"金额为"+target);
            capital -= target;
        }
    }
}
