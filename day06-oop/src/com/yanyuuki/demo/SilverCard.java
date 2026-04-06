package com.yanyuuki.demo;

public class SilverCard extends Card{

    public SilverCard(String carId,String name,String phone,double money){
        super(carId,name,phone,money);
    }

    //银卡九折
    public void consume(double money){
        System.out.println("您当前消费:"+money);
        System.out.println("您实际消费:"+money*0.9);
        if(getMoney()<money*0.9){
            System.out.println("余额不足");
            return;
        }
        //更新银卡金额
        setMoney(getMoney()-money*0.9);

    }
}
