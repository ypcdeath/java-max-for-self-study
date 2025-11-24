package com.itheima.demo2reflect;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrame {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("2025-Chapter6-junit-reflect-annotation-proxy/src/com/itheima/demo2reflect/savedata.txt",true));
        Class c = obj.getClass();
        String simpleName = c.getSimpleName();
        ps.println("=========="+simpleName+"==========");
        //获取c 的所有属性
        Field[] fields = c.getDeclaredFields();
        //遍历所有字段
        for (Field field : fields) {
            //拿字段名字
            String fieldName = field.getName();
            //拿字段值
            field.setAccessible(true);
            Object fieldValue = field.get(obj)+"";
            //打印字段名=字段值 到文件里去
            ps.println(fieldName+"="+fieldValue);
        }
        ps.close();
    }
}
