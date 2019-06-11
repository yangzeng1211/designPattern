package com.demo;

/**
 * @description: 备忘录模式
 * @author: yz
 * @create: 2019/6/11 11:16
 */
public class MementoPattern {
    public static void main(String[] args) {
        //得到发起人对象
        Originator or = new Originator();
        //管理者对象
        Caretaker cr = new Caretaker();
        //设置发起人初始状态为S0
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());

        //保存状态
        Memento memento = or.createMemento();
        cr.setMemento(memento);


        //设置发起人的新状态为S1
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());


        Memento oldMemento = cr.getMemento();
        or.restoreMemento(oldMemento); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}

//备忘录
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//发起人
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}

//管理者
class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}
