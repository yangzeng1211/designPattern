package com.demo;

/**
 * @description: 建造者模式 - 具体建造者：实现了抽象建造者接口
 * @author: yz
 * @create: 2019/6/10 16:14
 */
public class ConcreteBuilder1 extends Builder {
    public void buildPartA() {
        System.out.println("第一个具体建造者建造 PartA");
        product.setPartA("第一个具体建造者建造 PartA");
    }

    public void buildPartB() {
        System.out.println("第一个具体建造者建造 PartB");
        product.setPartB("第一个具体建造者建造 PartB");
    }

    public void buildPartC() {
        System.out.println("第一个具体建造者建造 PartC");
        product.setPartC("第一个具体建造者建造 PartC");
    }

}
