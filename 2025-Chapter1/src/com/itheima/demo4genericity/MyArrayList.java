package com.itheima.demo4genericity;

import java.util.ArrayList;

public class MyArrayList<E> {
    //可以多个泛型声明
//    Object[] arr = new Object[10];
    private ArrayList<E> arr = new ArrayList<>();
    public boolean add(E e){
        return arr.add(e);
    }

    public boolean remove(E e){
        return arr.remove(e);
    }

    @Override
    public String toString() {
        return arr.toString();
    }

    public E get(int index){
        return arr.get(index);
    }
}
