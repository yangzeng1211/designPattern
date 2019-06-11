package com.demo;

/**
 * @description: 策略模式
 * @author: yz
 * @create: 2019/6/11 10:25
 */
public class StrategyPattern {
    public static void main(String[] args) {
        //获取环境对象
        Context c = new Context();
        //获取策略对象
        Strategy s = new ConcreteStrategyA();
        //把策略对象传给环境对象的成员变量
        c.setStrategy(s);
        //执行环境对象提供的对应方法
        c.strategyMethod();
        System.out.println("-----------------");

        Strategy b = new ConcreteStrategyB();
        c.setStrategy(b);
        c.strategyMethod();
    }
}

//抽象策略类
interface Strategy {
    public void strategyMethod(); //策略方法
}

//具体策略类A
class ConcreteStrategyA implements Strategy {
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}

//具体策略类B
class ConcreteStrategyB implements Strategy {
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}

//环境类
class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
