package com.demo3;

import java.util.HashMap;

/**
 * @description: 状态模式
 * @author: yz
 * @create: 2019/6/11 10:51
 */
public class FlyweightStatePattern {
    public static void main(String[] args) {
        ShareContext context = new ShareContext(); //创建环境
        context.Handle(); //处理请求
        context.Handle(); //处理请求
        context.Handle(); //处理请求
        context.Handle(); //处理请求

    }
}

//环境类
class ShareContext {
    private ShareState state;
    private HashMap<String, ShareState> stateSet = new HashMap<String, ShareState>();

    public ShareContext() {
        state = new ConcreteState1();
        stateSet.put("1", state);
        state = new ConcreteState2();
        stateSet.put("2", state);
        state = getState("1");
    }

    //设置新状态
    public void setState(ShareState state) {
        this.state = state;
    }

    //读取状态
    public ShareState getState(String key) {
        ShareState s = (ShareState) stateSet.get(key);
        return s;
    }

    //对请求做处理
    public void Handle() {
        state.Handle(this);
    }
}

//抽象状态类
abstract class ShareState {
    public abstract void Handle(ShareContext context);
}

//具体状态1类
class ConcreteState1 extends ShareState {
    public void Handle(ShareContext context) {
        System.out.println("当前状态是： 状态1");
        context.setState(context.getState("2"));
    }
}

//具体状态2类
class ConcreteState2 extends ShareState {
    public void Handle(ShareContext context) {
        System.out.println("当前状态是： 状态2");
        context.setState(context.getState("1"));
    }
}
