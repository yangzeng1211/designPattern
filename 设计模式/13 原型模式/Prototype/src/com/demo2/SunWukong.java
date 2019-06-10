package com.demo2;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @description: 原型模式示例
 * @author: yz
 * @create: 2019/6/6 14:35
 */
public class SunWukong extends JPanel implements Cloneable {
    private static final long serialVersionUID = -6281368292527379739L;

    public SunWukong() {
//        JLabel l1 = new JLabel(new ImageIcon("src/Wukong.jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(SunWukong.class.getResource("Wukong.jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.add(l1);
    }

    public Object clone() {
        SunWukong w = null;
        try {
            w = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败!");
        }
        return w;
    }
}
