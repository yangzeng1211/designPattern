package com.demo2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @description: 桥接模式 - 示例 & 测试
 * @author: yz
 * @create: 2019/6/10 17:15
 */
public class BagManage {
    public static void main(String[] args) {
        Color color = (Color) ReadXML.getObject("color");
        Bag bag = (Bag) ReadXML.getObject("bag");
        bag.setColor(color);
        Size size = (Size) ReadXML.getObject("size");
        bag.setSize(size);
        String name = bag.getName();
        show(name);
    }

    public static void show(String name) {
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
//        JLabel l = new JLabel(new ImageIcon("src/com/demo2/" + name + ".jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(BagManage.class.getResource(name+".jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l1);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//实现化角色：颜色
interface Color {
    String getColor();
}

//具体实现化角色：黄色
class Yellow implements Color {
    public String getColor() {
        return "yellow";
    }
}

//具体实现化角色：红色
class Red implements Color {
    public String getColor() {
        return "red";
    }
}

//实现化角色：大小
interface Size{
    String getSize();
}

//具体实现化角色：大
class Big implements Size{
    public String getSize() {
        return "big";
    }
}

//具体实现化角色：中
class Middle implements Size{
    public String getSize() {
        return "middle";
    }
}

//具体实现化角色：小
class Small implements Size{
    public String getSize() {
        return "small";
    }
}

//抽象化角色：包
abstract class Bag {
    protected Color color;

    protected Size size;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag {
    public String getName() {
        System.out.println(color.getColor() + "HandBag"+"  型号："+size.getSize());
        return color.getColor() + "HandBag";
    }
}

//扩展抽象化角色：钱包
class Wallet extends Bag {
    public String getName() {
        System.out.println(color.getColor() + "HandBag"+"  型号："+size.getSize());
        return color.getColor() + "Wallet";
    }
}
