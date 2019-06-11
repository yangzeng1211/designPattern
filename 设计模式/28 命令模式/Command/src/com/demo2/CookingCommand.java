package com.demo2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @description: 命令模式
 * @author: yz
 * @create: 2019/6/11 10:42
 */
public class CookingCommand {
    public static void main(String[] args) {
        Waiter fwy = new Waiter();
        Breakfast changFen = new ChangFen();
        fwy.setChangFen(changFen);
        fwy.chooseChangFen();

        Breakfast hunTun = new HunTun();
        fwy.setHunTun(hunTun);
        fwy.chooseHunTun();
    }
}

//调用者：服务员
class Waiter {
    private Breakfast changFen, hunTun, heFen;

    public void setChangFen(Breakfast f) {
        changFen = f;
    }

    public void setHunTun(Breakfast f) {
        hunTun = f;
    }

    public void setHeFen(Breakfast f) {
        heFen = f;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }

    public void chooseHunTun() {
        hunTun.cooking();
    }

    public void chooseHeFen() {
        heFen.cooking();
    }
}

//抽象命令：早餐
interface Breakfast {
    public abstract void cooking();
}

//具体命令：肠粉
class ChangFen implements Breakfast {
    private ChangFenChef receiver;

    ChangFen() {
        receiver = new ChangFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：馄饨
class HunTun implements Breakfast {
    private HunTunChef receiver;

    HunTun() {
        receiver = new HunTunChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//具体命令：河粉
class HeFen implements Breakfast {
    private HeFenChef receiver;

    HeFen() {
        receiver = new HeFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

//接收者：肠粉厨师
class ChangFenChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    ChangFenChef() {
        super("煮肠粉");
//        l.setIcon(new ImageIcon("src/com/demo2/ChangFen.jpg"));
        String imagePath = null;
        try {
            imagePath = URLDecoder.decode(ChangFenChef.class.getResource("ChangFen.jpg").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        l.setIcon(new ImageIcon(imagePath));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}

//接收者：馄饨厨师
class HunTunChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HunTunChef() {
        super("煮馄饨");
//        l.setIcon(new ImageIcon("src/com/demo2/HunTun.jpg"));
        String imagePath = null;
        try {
            imagePath = URLDecoder.decode(HunTunChef.class.getResource("HunTun.jpg").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        l.setIcon(new ImageIcon(imagePath));
        this.add(l);
        this.setLocation(350, 50);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}

//接收者：河粉厨师
class HeFenChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HeFenChef() {
        super("煮河粉");
//        l.setIcon(new ImageIcon("src/com/demo2/HeFen.jpg"));
        String imagePath = null;
        try {
            imagePath = URLDecoder.decode(HeFenChef.class.getResource("HeFen.jpg").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        l.setIcon(new ImageIcon(imagePath));
        this.add(l);
        this.setLocation(200, 280);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}
