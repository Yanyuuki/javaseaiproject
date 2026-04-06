package com.yanyuuki.demo;
//金卡必须重写消费方法，八折消费
public class GoldCard extends Card{

    public GoldCard(String carId,String name,String phone,double money){
        super(carId, name, phone, money);
    }

    @Override
    public void consume(double money){
        System.out.println("您当前消费:"+money);
        System.out.println("您实际消费:"+money*0.8);
        if(getMoney()<money*0.8){
            System.out.println("余额不足");
            return;
        }
        //更新金卡的金额
        setMoney(getMoney()-money*0.8);

        //判断消费是否大于200，调用独有功能，打印洗车票
        if(money*0.8>=200){
            printTicket();
        }
        else {
            System.out.println("当前消费金额不足200");
        }
    }

    //打印洗车票
    public void printTicket(){
        System.out.println(" 当前消费金额满200，请打印洗车");
    }
}
