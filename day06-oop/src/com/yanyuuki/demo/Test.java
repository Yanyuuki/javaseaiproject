package com.yanyuuki.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //加油站支付小程序
        //1.创建卡片类，以便创建金卡或者银卡对象，封装车主的数据
        //2.定义卡片父类，Card,定义金卡和银卡的共同属性和方法
        //3.创建金卡类，继承卡片类，实现金卡特有属性和方法
        //4.办理一张金卡，创建金卡对象，交给一个独立的业务(支付机)来完成，存款，消费
        //5.创建银卡类，继承卡片类，实现银卡特有属性和方法
        //6.办理一张银卡，创建银卡对象，交给一个独立的业务(支付机)来完成，存款，消费
        GoldCard gc = new GoldCard("赣B54I88","Yany_uki","18271190611",5000);
        SilverCard sc = new SilverCard("粤BO0721","Yany_uki","18870793600",3000);
        pay(gc);
    }

    public static void pay(Card c){
        System.out.println("请刷卡");
        System.out.println("请输入消费的金额");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextInt();
        c.consume(money);
    }

}
