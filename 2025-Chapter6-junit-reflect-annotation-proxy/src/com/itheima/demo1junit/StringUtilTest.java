package com.itheima.demo1junit;

import org.junit.Assert;
import org.junit.Test;


public class StringUtilTest {
    //测试方法 必须是公开public 无参 无参数返回
    //测试方法必须添加@Test注解（Junit框架的核心步骤）
    @Test
    public void testPrintNumber(){
        //测试步骤
        StringUtil.printNumber("张三abc");//5
        //测试用例
        StringUtil.printNumber("");//0
        StringUtil.printNumber(null);//-1
    }

    @Test
    public void testGetMaxIndex(){
        //测试步骤
        StringUtil.getMaxIndex("张三123");//5
        //测试用例
        StringUtil.getMaxIndex("");//-1
        StringUtil.getMaxIndex(null);//-1
        Assert.assertEquals("本轮测试失败",4, StringUtil.getMaxIndex("张三123"));
    }

}
