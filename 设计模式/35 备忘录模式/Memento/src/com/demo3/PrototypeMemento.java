package com.demo3;

/**
 * @description: 备忘录模式
 * @author: yz
 * @create: 2019/6/11 11:23
 */
public class PrototypeMemento {
    public static void main(String[] args) {
        //得到发起人对象
        OriginatorPrototype or = new OriginatorPrototype();
        //得到管理者对象
        PrototypeCaretaker cr = new PrototypeCaretaker();
        //发起人初始状态
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());


        cr.setMemento(or.createMemento()); //保存状态

        //设置发起人新状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());

        //回滚
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}

//发起人原型
class OriginatorPrototype implements Cloneable {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public OriginatorPrototype createMemento() {
        return this.clone();
    }

    public void restoreMemento(OriginatorPrototype opt) {
        this.setState(opt.getState());
    }

    public OriginatorPrototype clone() {
        try {
            return (OriginatorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//原型管理者
class PrototypeCaretaker {
    private OriginatorPrototype opt;

    public void setMemento(OriginatorPrototype opt) {
        this.opt = opt;
    }

    public OriginatorPrototype getMemento() {
        return opt;
    }
}
