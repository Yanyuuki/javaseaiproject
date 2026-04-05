package com.yanyuuki.staticfield;

public class Test2 {
    public static void main(String[] args) {
        //了解静态变量的应用
        new User();
        new User();
        new User();
        System.out.println(User.cnt);
    }
}
