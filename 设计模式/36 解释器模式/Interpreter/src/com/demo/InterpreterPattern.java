package com.demo;

/**
 * @description: 解释器模式
 * @author: yz
 * @create: 2019/6/11 11:25
 */
public class InterpreterPattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.operation("");
    }

}

//抽象表达式类
interface AbstractExpression {
    public Object interpret(String info); //解释方法
}

//终结符表达式类
class TerminalExpression implements AbstractExpression {
    public Object interpret(String info) {
        //对终结符表达式的处理
        return info;
    }
}

//非终结符表达式类
class NonterminalExpression implements AbstractExpression {
    private AbstractExpression exp1;
    private AbstractExpression exp2;

    public Object interpret(String info) {
        //非对终结符表达式的处理
        return info;
    }
}

//环境类
class Context {
    private AbstractExpression exp;

    public Context() {
        //数据初始化
    }

    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}
