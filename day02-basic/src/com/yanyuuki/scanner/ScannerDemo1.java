package com.yanyuuki.scanner;

import java.util.Scanner;

public class ScannerDemo1 {

    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示 Scanner 类的基本使用，从控制台获取用户输入
 * 1. 读取字符串类型的用户名
 * 2. 读取整数类型的年龄
 *
 * @param args 命令行参数数组
 */
public static void main(String []args) {
    // 创建 Scanner 对象用于读取控制台输入
    Scanner sc=new Scanner(System.in);

    // 读取并输出用户名
    System.out.println("请输入用户名:");
    String username=sc.next();
    System.out.println("用户名是:"+username);

    // 读取并输出年龄
    System.out.println("请输入年龄:");
    int age=sc.nextInt();
    System.out.println("您的岁数是"+age);
}

}
