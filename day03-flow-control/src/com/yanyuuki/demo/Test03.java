package com.yanyuuki.demo;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入位数：");
        int n=sc.nextInt();
        System.out.println(getCode1(n));
        System.out.println(getCode2(n));
    }
    public static int getCode1(int n){
        int code=0;
        for(int i=0;i<n;i++){
            code+=(int)(Math.random()*10);
            code*=10;
        }
        return code/10;
    }
    public static String getCode2(int n){
        String code="";
        for(int i=0;i<n;i++){
            int type=(int)(Math.random()*3);//随机 数字 小写 大写
            switch (type) {
                case 0:
                    code += (int) (Math.random() * 10);
                    break;
                case 1:
                    code += (char) (Math.random() * 26 + 'a');
                    break;
                case 2:
                    code += (char) (Math.random() * 26 + 'A');
                    break;
                default:
                    break;

            }
        }
        return code;
    }
}
