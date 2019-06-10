package com.demo3;

/**
 * @description: 原型模式测试
 * @author: yz
 * @create: 2019/6/10 10:39
 */
public class ProtoTypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation obj1 = new Citation("张三", "同学：在2019学年第一学期中表现优秀，被评为三好学生。", "湖南大学");
        obj1.display();
        Citation obj2 = (Citation) obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}
