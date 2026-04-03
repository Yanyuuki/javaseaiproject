package com.yanyuuki.branch;

import java.util.Scanner;

public class SwitchDemo3 {
    /**
     * 程序主入口方法
     * 调用测试方法演示 switch 语句的使用
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {

        test1();
    }

    public static void test1(){
        System.out.println("请输入您的性别：");
        Scanner sc= new Scanner(System.in);
        String sex=sc.next();
        switch (sex){
            case "男":
                System.out.println("你是一个男性");
                break;
            case "女":
                System.out.println("你是一个女性");
                break;
            default:
                System.out.println("请输入正确的性别");
                break;
        }
    }
}
