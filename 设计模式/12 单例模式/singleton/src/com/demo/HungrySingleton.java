package com.demo;

/**
 * @description: 饿汉式单例
 * @author: yz
 * @create: 2019/6/6 12:53
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
