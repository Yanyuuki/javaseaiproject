package com.yanyuuki.loop;

public class WhileTest5 {
    public static void main(String[] args) {
        System.out.println(test1());
    }
    public static int test1(){
        double money=100000;//本金
        double rate=0.017;//利息
        int year=0;
        while(money<200000){
            money*=(1+rate);
            year++;
        }
        return year;
    }
}
