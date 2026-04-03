package com.yanyuuki.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        //学习自增自减
        print();
        print2();
    }
    public static void print(){
        int a=10;
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);

        a--;
        System.out.println(a);
        --a;
        System.out.println(a);
    }

    public static  void print2(){
        int a=10;
        int b=a++;
        System.out.println(a);
        System.out.println(b);

        int c=++a;
        System.out.println(a);
        System.out.println(c);

    }
}
