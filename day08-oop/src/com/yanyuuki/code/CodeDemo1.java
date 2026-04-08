package com.yanyuuki.code;

import java.util.Arrays;

public class CodeDemo1 {
    public static String schoolName;
    public static String[] cards=new String[54];

    //静态代码块，有static修饰，属于类，与类一起有限加载，自动执行一次
    static{
        schoolName = "湖北大学";
        cards[0]="大王";
        cards[1]="小王";
        for(int i=2;i<=13;i++){
            cards[i]="♠"+i;
        }
        for(int i=14;i<=26;i++){
            cards[i]="♥"+i;
        }
        for(int i=27;i<=39;i++){
            cards[i]="♣"+i;
        }
        for(int i=40;i<=52;i++){
            cards[i]="♦"+i;
        }
        System.out.println("静态代码块执行了");
    }

    public static void main(String[] args) {
        //认识代码块，搞清楚代码块的基本作用
        System.out.println("main方法执行了");
        System.out.println(schoolName);
        System.out.println(Arrays.toString(cards));


    }
}
