package com.yanyuuki.singleinstance;

public class Test {
    public static void main(String[] args) {
        //设计单例类(饿汉式单例)
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        System.out.println(a1==a2);
        //设计单例类对象(懒汉式单例)
        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1==b2);
    }
}
