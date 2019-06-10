package com.demo4;

/**
 * @description: 原型模式 - 基类
 * @author: yz
 * @create: 2019/6/10 10:41
 */
public interface Shape extends Cloneable {
    Object clone(); //拷贝

    void countArea(); //计算面积
}
