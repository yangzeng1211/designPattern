package com.demo3;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @description: 饿汉式单例示例
 * @author: yz
 * @create: 2019/6/6 12:58
 */
public class Bajie extends JPanel {
    private static final long serialVersionUID = 3838175884560920622L;
    private static Bajie instance = new Bajie();

    private Bajie() {
//        JLabel l1 = new JLabel(new ImageIcon("src/Bajie.jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(Bajie.class.getResource("Bajie.jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.add(l1);
    }

    public static Bajie getInstance() {
        return instance;
    }
}
