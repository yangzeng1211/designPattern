package com.demo4;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @description: 代理模式 - Cglib子类代理工厂，生成动态代理
 * @author: yz
 * @create: 2019/6/10 16:59
 */
public class ProxyFactory implements MethodInterceptor{
    // 维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    /*
     *  定义拦截器，在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，
     *  来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("向观众问好");
        //执行目标对象的方法
        //Object returnValue = method.invoke(target, args);
        Object returnValue = proxy.invokeSuper(obj, args);
        System.out.println("谢谢大家");
        return returnValue;
    }
}
