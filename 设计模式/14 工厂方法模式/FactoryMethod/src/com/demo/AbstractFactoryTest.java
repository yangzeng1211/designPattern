package com.demo;

/**
 * @description: 工厂方法模式 - 示例 & 测试
 * @author: yz
 * @create: 2019/6/10 10:50
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        try {
            //AbstractFactory af = new ConcreteFactory1();
            AbstractFactory af = (AbstractFactory) ReadXML.getObject();
            Product a = af.newProduct();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：提供了产品的接口
interface Product {
    void show();
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

//抽象工厂：提供了产品的生成方法
interface AbstractFactory {
    Product newProduct();
}

//具体工厂1：实现了的生成方法
class ConcreteFactory1 implements AbstractFactory {
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}

//具体工厂2：实现了产品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
