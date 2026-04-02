package com.yanyuuki.variable;

public class VariableDemo1 {
    public static void main(String []args){
        //变量
        int a=10;
        System.out.println(a);
        System.out.println(a);
        System.out.println(a+1);

        System.out.println("=============");

        double score=98.5;
        System.out.println(score);
        System.out.println(score);
        System.out.println(score+1);

        System.out.println("=============");

        char ch='a';
        System.out.println(ch);

        System.out.println("=============");

        int age=18;
        age++;
        System.out.println(age);
        System.out.println(age++);
        System.out.println(++age);

        age=200;
        System.out.println(age);

        //Ascii码

        char ch1='A';
        System.out.println(ch1);
        System.out.println((int)ch1);
        System.out.println(ch1+1);
        System.out.println((char)(ch1+1));

        //直接输入进制
        System.out.println(0xA);//10,十六进制
        System.out.println(010);//8,八进制
        System.out.println(0b1010);//10,二进制
        System.out.println(0B1010);//10,二进制
        System.out.println(0xA+1);//11,十六进制
        System.out.println(010+1);//9,八进制
        System.out.println(0b1010+1);//11,二进制

    }
}
