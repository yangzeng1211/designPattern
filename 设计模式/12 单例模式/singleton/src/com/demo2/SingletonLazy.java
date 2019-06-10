package com.demo2;

/**
 * @description: 懒汉式单例示例测试
 * @author: yz
 * @create: 2019/6/6 12:56
 */
public class SingletonLazy {
    public static void main(String[] args) {
        President zt1 = President.getInstance();
        zt1.getName(); //输出总统的名字
        President zt2 = President.getInstance();
        zt2.getName(); //输出总统的名字
        if (zt1 == zt2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}
