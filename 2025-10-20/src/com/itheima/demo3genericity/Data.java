package com.itheima.demo3genericity;

public interface Data<T>{
    //泛型接口T：表示任意的数据类型
    void add(T t);
    void remove(T t);
    void update(T t);
    T query(int id);
}
