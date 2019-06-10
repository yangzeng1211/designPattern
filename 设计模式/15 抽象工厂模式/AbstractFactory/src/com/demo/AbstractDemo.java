package com.demo;

/**
 * @description: 抽象工厂模式
 * @author: yz
 * @create: 2019/6/10 15:14
 */
public class AbstractDemo {

    public static void main(String[] args) {
        //生成抽象工厂规范的具体工厂对象
        AbstractFactory1 af = new ConcreteFactory01();

        //用具体工厂生产所有的产品---得到了具体的产品对象
        Product1 p1 = af.newProduct1();
        Product2 p2 = af.newProduct2();

        //可以调用具体产品的展示方法了
        p1.show();
        p2.show();
    }

}

/*
 * 抽象产品1
 */
interface Product1{
    void show();
}

/*
 * 具体产品1
 */
class ConcreteProduct11 implements Product1{
    public void show() {
        System.out.println("显示工厂1生产的产品1");
    }
}

class ConcreteProduct12 implements Product1{
    public void show() {
        System.out.println("显示工厂2生产的产品1");
    }
}

/*
 * 抽象产品2
 */
interface Product2{
    void show();
}

/*
 * 具体产品2
 */
class ConcreteProduct21 implements Product2{
    public void show() {
        System.out.println("显示工厂1生产的产品2");
    }
}

class ConcreteProduct22 implements Product2{
    public void show() {
        System.out.println("显示工厂2生产的产品2");
    }
}

/*
 * 抽象工厂接口
 */
interface AbstractFactory1 {
    Product1 newProduct1();
    Product2 newProduct2();
}

/*
 * 具体工厂1
 */
class ConcreteFactory01 implements AbstractFactory1{
    public Product1 newProduct1() {
        System.out.println("工厂1生产了产品1");
        return new ConcreteProduct11();
    }

    public Product2 newProduct2() {
        System.out.println("工厂1生产了产品2");
        return new ConcreteProduct21();
    }
}

/*
 * 具体工厂2
 */
class ConcreteFactory02 implements AbstractFactory1{
    public Product1 newProduct1() {
        System.out.println("工厂2生产了产品1");
        return new ConcreteProduct12();
    }

    public Product2 newProduct2() {
        System.out.println("工厂2生产了产品2");
        return new ConcreteProduct22();
    }
}
