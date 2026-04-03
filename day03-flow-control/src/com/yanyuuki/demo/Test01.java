package com.yanyuuki.demo;

import java.util.Scanner;

public class Test01 {
    /**
     * 测试
     * 计算器
     * 输入两个数字，进行运算
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        String op=sc.next();
        double b=sc.nextDouble();
        calc(a,b,op);
    }
    public static void calc(double a,double b,String op){
        switch (op){
            case "+":
                System.out.println(a+b);
                break;
            case "-":
                System.out.println(a-b);
                break;
            case "*":
                System.out.println(a*b);
                break;
            case "/":
                System.out.println(a/b);
                break;
            default:
                System.out.println("输入的运算符有误");
                break;
        }
    }
}
