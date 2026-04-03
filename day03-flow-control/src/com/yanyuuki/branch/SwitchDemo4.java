package com.yanyuuki.branch;

import java.util.Scanner;

public class SwitchDemo4 {
    /**
     * 程序主入口方法
     * 演示 switch 语句的穿透性特性
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        //搞清楚switch的注意事项，穿透性的应用

        test3();

    }
    //1.switch不支持double，float,long,
    //表达类型只能是byte，short，int，char，枚举，String
    public static void test1(){
/*      double a=10.5;
        switch (a){
            case 10:
                System.out.println("10");
                break;
            case 20:
                System.out.println("20");
                break;
            default:
                System.out.println("其他");
        }
*/
    }
    //2.case给出的值不能重复，且只能是字面量，不能是变量
    public static void test2(){
/*      int a=10;
        int b=20;
        switch (a){
            case 10:
                System.out.println("10");
                break;
            case b:
                System.out.println("20");
                break;
            default:
                System.out.println("其他");
        }
 */
    }
    //3.switch记得写break，否则会穿透
    public static void test3(){
        String week;
        Scanner sc = new Scanner(System.in);
        week = sc.next();
        switch (week){
            case "星期一":
                System.out.println("1");
            case "星期二":
                System.out.println("2");
            case "星期三":
                System.out.println("3");
            case "星期四":
                System.out.println("4");
            case "星期五":
                System.out.println("5");
                break;
            case "星期六":
                System.out.println("6");
            case "星期日":
                System.out.println("7");
                break;
            default:
                System.out.println("星期信息有误");
        }
    }

}

