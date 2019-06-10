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
import javax.swing.JScrollPane;

/**
 * @description: 工厂方法模式 - 示例 & 测试
 * @author: yz
 * @create: 2019/6/10 14:22
 */
public class AnimalFarmTest {
    public static void main(String[] args) {
        try {
            AnimalFarm af = (AnimalFarm) ReadXML2.getObject();
            Animal a = af.newAnimal();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//抽象产品：动物类
interface Animal {
    void show();
}

//具体产品：马类
class Horse implements Animal {
    JScrollPane sp;
    JFrame jf = new JFrame("工厂方法模式测试");

    public Horse() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
        sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
//        JLabel l1 = new JLabel(new ImageIcon("src/com/demo2/A_Horse.jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(Horse.class.getResource("A_Horse.jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //用户点击窗口关闭
    }

    public void show() {
        //让组件显示
        jf.setVisible(true);
    }
}

//具体产品：牛类
class Cattle implements Animal {
    JScrollPane sp;
    JFrame jf = new JFrame("工厂方法模式测试");

    public Cattle() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
        sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
//        JLabel l1 = new JLabel(new ImageIcon("src/com/demo2/A_Cattle.jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(Cattle.class.getResource("A_Cattle.jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //用户点击窗口关闭
    }

    public void show() {
        jf.setVisible(true);
    }
}

//抽象工厂：畜牧场
interface AnimalFarm {
    Animal newAnimal();
}

//具体工厂：养马场
class HorseFarm implements AnimalFarm {
    public Animal newAnimal() {
        System.out.println("新马出生！");
        return new Horse();
    }
}

//具体工厂：养牛场
class CattleFarm implements AnimalFarm {
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        return new Cattle();
    }
}
