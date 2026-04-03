package com.yanyuuki.branch;

public class IfTest2 {
    /**
     * 程序主入口方法
     * 调用测试方法演示 if-else 条件语句的使用
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        boolean red=true;
        boolean yellow=false;
        boolean green=false;

        if(red){
            System.out.println("红灯亮");
        }
        else if(yellow){
            System.out.println("黄灯亮");
        }
        else{
            System.out.println("绿灯亮");
        }
    }
}
