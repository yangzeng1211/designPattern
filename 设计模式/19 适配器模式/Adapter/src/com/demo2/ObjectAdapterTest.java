package com.demo2;

/**
 * @description: 适配器模式
 * @author: yz
 * @create: 2019/6/10 17:07
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}

//目标接口
interface Target {
    public void request();
}

//适配者类
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

//对象适配器类
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        System.out.println("做一些其他的前置功能");
        adaptee.specificRequest();
        System.out.println("做一些其他的后置功能");
    }
}
