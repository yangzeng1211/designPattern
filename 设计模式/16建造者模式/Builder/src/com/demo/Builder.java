package com.demo;

/**
 * @description: 建造者模式 - 抽象建造者：包含创建产品各个子部件的抽象方法
 * @author: yz
 * @create: 2019/6/10 16:13
 */
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
