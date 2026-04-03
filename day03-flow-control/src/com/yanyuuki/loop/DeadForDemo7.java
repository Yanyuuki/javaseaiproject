package com.yanyuuki.loop;

import java.util.Scanner;

public class DeadForDemo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag=0;
        flag=sc.nextInt();
        switch (flag){
            case 1:
                test1();
                break;
            case 2:
                test2();
                break;
            default:
                System.out.println("请输入正确的数字");
                break;
        }
    }
    public static void test1(){
        int i=0;
        for(;;){
            System.out.println(i);
            i++;
        }
    }
    public static void test2(){
        int i=0;
        while(true){
            System.out.println(i);
            i++;
        }
    }
}
