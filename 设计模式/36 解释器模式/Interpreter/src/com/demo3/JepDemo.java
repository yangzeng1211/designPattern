package com.demo3;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

/**
 * @description: 解释器模式
 * @author: yz
 * @create: 2019/6/11 11:27
 */
public class JepDemo {
    public static void main(String[] args) throws JepException {
        Jep jep = new Jep();
        //定义要计算的数据表达式
        String 存款利息 = "本金*利率*时间";
        //给相关变量赋值
        jep.addVariable("本金", 10000);
        jep.addVariable("利率", 0.038);
        jep.addVariable("时间", 2);
        jep.parse(存款利息); //解析表达式
        Object accrual = jep.evaluate(); //计算
        System.out.println("存款利息：" + accrual);
    }
}
