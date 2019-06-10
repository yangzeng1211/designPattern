package com.demo;

/**
 * @description: 建造者模式 - 产品角色：包含多个组成部件的复杂对象
 * @author: yz
 * @create: 2019/6/10 15:55
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        //显示产品的特性
        System.out.println("产品的特性:"+"   "+partA+"   "+partB+"   "+partC);
    }
}
