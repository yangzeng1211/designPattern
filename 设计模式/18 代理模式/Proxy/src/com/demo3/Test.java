package com.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 代理模式 - 动态代理测试
 * @author: yz
 * @create: 2019/6/10 16:57
 */
public class Test {
    public static void main(String[] args) {
        ISinger target = new Singer();
        ISinger proxy = (ISinger) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("向观众问好");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("谢谢大家");
                        return returnValue;
                    }
                });
        proxy.sing();
    }
}


interface ISinger {
    void sing();
}

/**
 *  目标对象实现了某一接口
 */
class Singer implements ISinger {
    public void sing() {
        System.out.println("唱一首歌");
    }
}
