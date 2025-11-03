package com.itheima.testdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String size;
    private String color;

    @Override
    public String toString() {
        return size + color;
    }
}
