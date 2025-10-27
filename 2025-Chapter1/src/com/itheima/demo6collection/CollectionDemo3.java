package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo3 {
    public static void main(String[] args) {
        //目标： 集合的3种遍历方式
        //一.迭代器遍历
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        names.add("田七");
        System.out.println(names);//[张三, 李四, 王五, 赵六, 田七]
        //                            it
        //1.得到迭代器对象
        Iterator<String> it = names.iterator();
        //it 初始是在第一个位置
        //取了再迭代到下一个位置
        while (it.hasNext()) {
            //hasNext() 判断集合中是否有一个元素
            String name = it.next();
            System.out.println(name);
        }

        System.out.println("------------------");
        //二，增强for遍历

    }
}
