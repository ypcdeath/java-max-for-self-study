package com.itheima.demo4proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Star implements StarService{
    private String name;

    @Override
    public void sing(String name) {
        System.out.println(this.name+"正在唱"+name+"...");
    }

    @Override
    public String dance(String name) {
        System.out.println(this.name+"正在跳"+name+"...");
        return "跳完"+name+"谢谢大家~";
    }
}
