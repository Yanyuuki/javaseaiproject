package com.yanyuuki.operator;

public class OperatorDemo3 {
    public static void main(String[] args) {
        recieve(10);
    }

    public static void recieve(int b) {
        int a=100;
        a+=b;//自带强转类型转换
        System.out.println(a);

        a-=b;
        System.out.println(a);

        a*=b;
        System.out.println(a);

        a/=b;
        System.out.println(a);

        a%=b;
        System.out.println(a);
    }
}
