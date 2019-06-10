package com.demo;

/**
 * @description: 原型模式-具体原型类
 * @author: yz
 * @create: 2019/6/6 14:28
 */
public class Realizetype implements Prototype {
    public Realizetype() {
        System.out.println("具体原型创建成功！");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();

    }
}
