package com.yanyuuki.method;

public class MethodDemo1 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 1. 调用 getSum() 方法计算两个整数的和并输出结果
 * 2. 调用 printHello() 方法打印问候语
 * 3. 调用 getCode() 方法生成指定长度的验证码并输出
 *
 * @param args 命令行参数数组
 */
public static void main(String[] args){
    // 调用求和方法并输出结果
    int a=1;
    int b=2;
    int c=getSum(a,b);
    System.out.println(a+"和"+b+"的和是:"+c);

    // 分隔线
    System.out.println("===========");

    // 再次调用求和方法并输出
    int sum=getSum(5,2);
    System.out.println("和是:"+sum);

    // 调用打印问候语方法
    printHello();

    // 分隔线
    System.out.println("===========");

    // 生成并输出指定长度的验证码
    String code=getCode(4);
    System.out.println("验证码是:"+code);
}



    public static int getSum(int a,int b){
        return a+b;
    }


    public static void printHello(){
        System.out.println("hello,world!");
        System.out.println("hello,world!");
        System.out.println("hello,world!");
    }


    public static String getCode(int length){
        String code="";
        for(int i=0;i<length;i++){
            int number=(int)(Math.random()*10);
            code+=number;
        }
        return code;
    }
}
