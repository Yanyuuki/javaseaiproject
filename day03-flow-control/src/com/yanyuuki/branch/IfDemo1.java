package com.yanyuuki.branch;

import java.util.Scanner;

public class IfDemo1 {
    /**
     * 程序主入口方法
     * 演示 if-else 条件语句的使用，包括年龄判断和成绩评级
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        //判断年龄是否大于18
        System.out.println("请输入年龄：");
        int age=0;
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
        test01(age);

        System.out.println("请输入分数：");
        int score = 0;
        score = sc.nextInt();
        test02(score);
    }

    public static void test01(int age){
        if(age>18){
            System.out.println("可以上网");
        }
        else{
            System.out.println("洗洗睡吧");
        }
    }

    public static void test02(int score){
        if(score>=90){
            System.out.println("A+");
        }
        else if(score>=80&&score<90){
            System.out.println("A");
        }
        else if(score>=70&&score<80){
            System.out.println("B");
        }
        else if(score>=60&&score<70){
            System.out.println("C");
        }
        else{
            System.out.println("D");
        }
    }
}
