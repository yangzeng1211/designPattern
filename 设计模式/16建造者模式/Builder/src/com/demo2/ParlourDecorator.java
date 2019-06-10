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
 * @description: 建造者模式 - 示例 & 测试
 * @author: yz
 * @create: 2019/6/10 16:21
 */
public class ParlourDecorator {
    public static void main(String[] args) {
        try {
            //获取装修师对象
            Decorator d = (Decorator) ReadXML.getObject();
            //根据装修师对象new项目经理对象
            ProjectManager m = new ProjectManager(d);
            //执行项目经理的生成产品对象的方法来生成产品对象
            Parlour p = m.decorate();
            //执行产品的显示方法
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//产品：客厅
class Parlour {
    private String wall; //墙
    private String TV; //电视
    private String sofa; //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public void show() {
        JFrame jf = new JFrame("建造者模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JScrollPane sp = new JScrollPane(p);
        String parlour = wall + TV + sofa;
//        JLabel l = new JLabel(new ImageIcon("src/com/demo2/" + parlour + ".jpg"));
        JLabel l1 = null;
        try {
            l1 = new JLabel(new ImageIcon(URLDecoder.decode(Parlour.class.getResource(parlour+".jpg").getPath(), "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("客厅"));
        p.add(l1);
        contentPane.add(sp, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//抽象建造者：装修工人
abstract class Decorator {
    //创建产品对象
    protected Parlour product = new Parlour();

    public abstract void buildWall();

    public abstract void buildTV();

    public abstract void buildSofa();

    //返回产品对象
    public Parlour getResult() {
        return product;
    }
}

//具体建造者：具体装修工人1
class ConcreteDecorator1 extends Decorator {
    public void buildWall() {
        product.setWall("w1");
    }

    public void buildTV() {
        product.setTV("TV1");
    }

    public void buildSofa() {
        product.setSofa("sf1");
    }
}

//具体建造者：具体装修工人2
class ConcreteDecorator2 extends Decorator {
    public void buildWall() {
        product.setWall("w2");
    }

    public void buildTV() {
        product.setTV("TV2");
    }

    public void buildSofa() {
        product.setSofa("sf2");
    }
}

//指挥者：项目经理
class ProjectManager {
    private Decorator builder;

    public ProjectManager(Decorator builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Parlour decorate() {
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}
