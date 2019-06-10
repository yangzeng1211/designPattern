package com.demo;

/**
 * @description: 装饰模式
 * @author: yz
 * @create: 2019/6/10 17:21
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        //创建具体构件角色的对象
        Component p = new ConcreteComponent();
        //创建具体装饰角色的对象
        Component d = new ConcreteDecorator(p);
        //调用具体装饰角色的功能，实际上中间访问了具体构件角色的方法
        d.operation();
    }
}

//抽象构件角色
interface Component {
    void operation();
}

//具体构件角色
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }

    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}

//抽象装饰角色
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

//具体装饰角色
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        preFunction();
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }

    public void preFunction() {
        System.out.println("为具体构件角色增加额外的功能preFunction()");
    }
}
