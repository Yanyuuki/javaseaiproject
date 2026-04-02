package com.yanyuuki.operator;

import java.util.Scanner;

public class OperatorDemo1 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示从控制台读取两个整数，并调用 print 方法进行运算处理
 *
 * @param args 命令行参数数组
 */
public static void main(String[] args) {
    // 创建 Scanner 对象用于读取控制台输入
    Scanner sc=new Scanner(System.in);

    // 读取用户输入的两个整数
    System.out.println("请输入第一个数字：");
    int a=sc.nextInt();
    System.out.println("请输入第二个数字：");
    int b=sc.nextInt();

    // 调用 print 方法处理两个数字
    print1(a,b);

    print2();
}


    public static void print1(int a,int b){
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(1.0* a/b);
        System.out.println(a%b);
    }

    //研究+符号是链接还是运算
    public static void print2(){
        int a=5;
        System.out.println("abc"+a);//abc5
        System.out.println(a+5);//10
        System.out.println("yanyuuki"+a+'a');//yanyuuki5a
        System.out.println(a+'a'+"yanyuuki");//102yanyuuki
    }

}
