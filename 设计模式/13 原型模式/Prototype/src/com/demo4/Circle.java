package com.demo4;

import java.util.Scanner;

/**
 * @description: 原型模式 - 圆
 * @author: yz
 * @create: 2019/6/10 10:41
 */
public class Circle implements Shape {
    public Object clone() {
        Circle w = null;
        try {
            w = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!");
        }
        return w;
    }

    public void countArea() {
        int r = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.14 * r * r + "\n");
    }
}
