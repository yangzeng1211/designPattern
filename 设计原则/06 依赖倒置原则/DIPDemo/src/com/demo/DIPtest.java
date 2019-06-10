package com.demo;

/**
 * @description: 依赖倒置原则
 * @author: yz
 * @create: 2019/6/6 12:31
 */
public class DIPtest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("顾客购买以下商品：");
        customer.shopping(new BeijingShop());
        customer.shopping(new ShanghaiShop());
    }
}

//商店
interface Shop {
    String sell(); //卖
}

//北京网店
class BeijingShop implements Shop {
    public String sell() {
        return "北京土特产：稻香村的糕点、月盛斋的酱肉、全聚德的烤鸭……";
    }
}

//上海网店
class ShanghaiShop implements Shop {
    public String sell() {
        return "上海土特产：奉贤黄桃、崇明水仙、松江大米……";
    }
}

//顾客
class Customer {
    public void shopping(Shop shop) {
        //购物
        System.out.println(shop.sell());
    }
}
