package com.demo4;

/**
 * @description: 代理模式 - Cglib动态代理测试
 * @author: yz
 * @create: 2019/6/10 17:00
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        Singer target = new Singer();
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(target);
        //代理对象
        Singer proxy = (Singer)proxyFactory.getProxyInstance();
        //执行代理对象的方法
        proxy.sing();
    }
}
