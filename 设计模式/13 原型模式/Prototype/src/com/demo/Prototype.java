package com.demo;

/**
 * @description: 原型模式接口
 * @author: yz
 * @create: 2019/6/6 14:27
 */
public interface Prototype extends Cloneable{

    Object clone() throws CloneNotSupportedException;

}
