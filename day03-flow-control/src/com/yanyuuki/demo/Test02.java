package com.yanyuuki.demo;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int flag=0;
        flag=sc.nextInt();
        switch (flag) {
            case 1:
                GuessNumber1();
                break;
            case 2:
                GuessNumber2();
                break;
        }
    }
    public static void GuessNumber1(){
        int number=(int)(Math.random()*100+1);//Math.random()生成[0,1)的随机数
        //System.out.println(number);测试代码
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        while(true){
            int num = sc.nextInt();
            if(num>number){
                System.out.println("数字太大了");
            }
            else if(num<number){
                System.out.println("数字太小了");
            }
            else{
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
    public static void GuessNumber2(){
        Random r=new Random();//得到一个随机数对象
        int luckNumber =r.nextInt(100)+1;//[0,100)+1->[1,101)
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        while(true){
            int num = sc.nextInt();
            if(num>luckNumber){
                System.out.println("数字太大了");
            }
            else if(num<luckNumber){
                System.out.println("数字太小了");
            }
            else{
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
}
