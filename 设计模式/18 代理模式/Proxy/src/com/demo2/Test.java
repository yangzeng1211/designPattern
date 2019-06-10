package com.demo2;

/**
 * @description: 代理模式 - 静态代理测试
 * @author: yz
 * @create: 2019/6/10 16:57
 */
public class Test {
    public static void main(String[] args) {
        //目标对象
        ISinger target = new Singer();
        //代理对象
        ISinger proxy = new SingerProxy(target);
        //执行的是代理的方法
        proxy.sing();
    }
}

interface ISinger {
    void sing();
}

/**
 *  目标对象实现了某一接口
 */
class Singer implements ISinger {
    public void sing() {
        System.out.println("唱一首歌");
    }
}

/**
 *  代理对象和目标对象实现相同的接口
 */
class SingerProxy implements ISinger {
    // 接收目标对象，以便调用sing方法
    private ISinger target;

    public SingerProxy(ISinger target) {
        this.target = target;
    }

    // 对目标对象的sing方法进行功能扩展
    public void sing() {
        System.out.println("向观众问好");
        target.sing();
        System.out.println("谢谢大家");
    }
}
