package com.yanyuuki.type;

public class TypeDemo2 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示数据类型转换和不同参数类型的方法调用
 * 1. calc1 接受多个不同类型的参数（int, double, char）
 * 2. calc2 接受 byte 类型参数，需要强制类型转换
 *
 * @param args 命令行参数数组
 */
public static void main(String []args) {
    // 调用多参数方法并输出结果
    System.out.println(calc1(10,20,30.56,'a'));

    // 分隔线
    System.out.println("=================");

    // 调用 byte 类型参数方法（使用强制类型转换）
    System.out.println(calc2((byte)10,(byte)20));
}


    public static double calc1(int a,int b,double c,char r){
        return a+b+c+r;
    }

    public static int calc2(byte a,byte b){
        return a+b;
    }

}
