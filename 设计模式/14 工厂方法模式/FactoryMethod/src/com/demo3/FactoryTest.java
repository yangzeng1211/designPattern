package com.demo3;

/**
 * @description: 简单工厂模式
 * @author: yz
 * @create: 2019/6/10 14:49
 */
public class FactoryTest {
    public static void main(String[] args) {
        try {
            Factory af = new Factory();
            Product a = af.factoryMethod(1);
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：提供了产品的接口
interface Product {
    public void show();
}

//具体产品1：实现抽象产品中的抽象方法
class ConcreteProduct1 implements Product {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}



class Factory{
    //工厂：生产产品
    public Product factoryMethod(int n) {
        if(n==1) {
            System.out.println("产品1...");
            return new ConcreteProduct1();
        }else if(n==2) {
            System.out.println("产品2...");
            return new ConcreteProduct2();
        }else {
            System.out.println("产品2...");
            return new ConcreteProduct2();
        }

    }
}
