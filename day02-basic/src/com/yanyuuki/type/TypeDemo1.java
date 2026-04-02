package com.yanyuuki.type;

public class TypeDemo1 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示 byte 类型的基本使用以及自动类型转换（隐式转换）
 * byte 类型传递给需要 int 参数的方法时会自动提升为 int
 *
 * @param args 命令行参数数组
 */
public static void main(String[] args){
    // 定义 byte 类型变量并输出
    byte a=12;
    System.out.println(a);

    // 调用 print 方法，byte 自动转换为 int
    print1(a);

    int b=20;
    System.out.println(b);
    byte c=(byte)b;
    print2(c);//强转类型转换

    double d=20.1;
    System.out.println(d);
    print1((int)d);
    print2((byte)d);


}


    public static void print1(int a){
        System.out.println(a);
    }

    public static void print2(byte a){
        System.out.println(a);
    }
}
