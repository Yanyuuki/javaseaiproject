package com.yanyuuki.operator;

public class OperatorDemo4 {
    public static void main(String[] args) {
        //学习判断运算符
        //学习三目运算符
        print1(10,2);
        print1(10,10);
        printMax(10,2);
    }

    public static void print1(int a,int b){
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println("\n");
    }

    public static void printMax(int a,int b){
        int result= a>b?a:b;
        System.out.println(result);
    }
}
