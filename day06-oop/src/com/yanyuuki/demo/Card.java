package com.yanyuuki.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok技术可以实现为类自动添加getter setter方法，无参构造器，toString方法等
@Data
@AllArgsConstructor//参数构造器
@NoArgsConstructor//无参构造器
public class Card {
    private String carId;//车牌号码
    private String name;
    private String phone;
    private double money;//余额

    //预存金额
    public void save(double money){
        this.money+=money;
    }
    //消费金额
    public void consume(double money){
        this.money-=money;
    }
}
