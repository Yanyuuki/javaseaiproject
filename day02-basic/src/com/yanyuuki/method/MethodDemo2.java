package com.yanyuuki.method;

public class MethodDemo2 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示方法重载（Overload）的使用，通过调用不同参数类型的 print() 方法
 * 展示 Java 如何根据参数类型和数量自动选择对应的方法版本
 *
 * @param args 命令行参数数组
 */
public static void main(String[] args) {
    // 调用单参数 print 方法测试不同类型

    print(10);
    print(10.1);
    print("hello,world!");
    print('a');
    print(true);

    // 调用双参数 print 方法
    print(10,20);
    print(10.1,20.1);
}


    public static void print(int a){
        System.out.println(a);
    }

    public static void print(double a){
        System.out.println(a);
    }

    public static void print(String a){
        System.out.println(a);
    }

    public static void print(char a){
        System.out.println(a);
    }

    public static void print(boolean a){
        System.out.println(a);
    }

    public static void print(int a,int b){
        System.out.println(a+b);
    }

    public static void print(double a,double b){
        System.out.println(a+b);
    }
}
