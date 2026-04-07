package com.yanyuuki.enumdemo;

public class Test {
    public static void main(String[] args) {
        //认识枚举类，搞清楚其基本特点
        A a1=A.X;
        System.out.println(a1);

        A a2=A.Y;
        System.out.println(a2);

        A a3=A.Z;
        System.out.println(a3);

        System.out.println("===================");
        System.out.println(a1.name());//枚举对象.name()X
        System.out.println(a2.name());//枚举对象.name()Y
        System.out.println(a1.ordinal());//索引0
        System.out.println(a2.ordinal());//索引1
    }
}
