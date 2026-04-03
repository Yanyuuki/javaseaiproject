package com.yanyuuki.operator;

public class OperatorDemo5 {
    public static void main(String[] args) {

        demo1();

    }

    public static void demo1(){
        //逻辑与
        boolean a = true;
        boolean b = false;
        System.out.println(a&&b);//短路
        System.out.println(a&b);
        //逻辑或
        System.out.println(a||b);//短路
        System.out.println(a|b);
        //逻辑非
        System.out.println(!a);
        System.out.println(!b);
        System.out.println("\n");
        //逻辑异或
        System.out.println(a^b);
        System.out.println(a^a);

    }
}
