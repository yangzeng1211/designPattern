package com.demo;

/**
 * @description: 建造者模式 - 客户类
 * @author: yz
 * @create: 2019/6/10 16:16
 */
public class BuilderClient {
    public static void main(String[] args) {
        //创建具体建造者对象
        Builder builder = new ConcreteBuilder1();
        //创建指挥着对象
        Director director = new Director(builder);
        //得到了复杂产品对象
        Product product = director.construct();
        //得到产品里面的展示方法
        product.show();
    }
}
