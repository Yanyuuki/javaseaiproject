package com.yanyuuki.stringdemo;

import java.util.Scanner;

public class StringDemo1 {
    public static void main(String[] args) {
        //目标：掌握创建字符串对象，封装要处理的字符串数据，调用String提供的方法处理字符串
        //1.推荐方式一：直接“”就可以创建字符串对象，封装字符串数据
        String s1="Hello World!";
        System.out.println(s1);
        System.out.println(s1.length());

        //2.方式二：通过构造器初始化对象
        String s2=new String();
        System.out.println(s2);

        String s3=new String("Hello World!");
        System.out.println(s3);

        char[] chars={'h','e','l','l','o'};
        String s4=new String(chars);
        System.out.println(s4);

        byte[] bytes={97,98,99,65,66,67};
        String s5=new String(bytes);
        System.out.println(s5);

        System.out.println("===================");

        //只用“”给出的字符串对象放在字符串常量区，只占有一份
        String s6="abc";
        String s7="abc";
        System.out.println(s6==s7);//true
        //其他的都放在堆区
        String s8=new String("abc");
        String s9=new String("abc");
        System.out.println(s8==s9);

        System.out.println("==================");
        //调用字符串的方法
        //简易版的登录
        String okLoginName="admin";
        System.out.println("请输入您的登录名称");
        Scanner sc=new Scanner(System.in);
        String loginName=sc.next();
        if(loginName.equals(okLoginName)){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }

        System.out.println("===================");
        //18271190611->182****0611
        System.out.println("请输入您的手机号");
        String phoneNumber=sc.next();
        System.out.println("系统显示一下手机号码进入");
        String start=phoneNumber.substring(0,3)+"****"+phoneNumber.substring(7);
        System.out.println(start);
    }
}
