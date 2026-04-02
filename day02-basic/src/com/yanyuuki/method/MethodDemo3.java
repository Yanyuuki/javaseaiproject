package com.yanyuuki.method;

public class MethodDemo3 {
    /**
 * 主方法 - 程序入口点
 *
 * 功能说明：
 * 演示除法运算中的异常情况，测试除数为 0 和正常除法两种场景
 *
 * @param args 命令行参数数组
 */
public static void main(String[] args){
    // 测试除法运算（包含除数为 0 的异常情况）
    div(10,0);
    div(10,2);
}


    public static void div(int a,int b){
        if(b==0){
            System.out.println("除数不能为零");
            return;
        }

        System.out.println(a/b);
    }


}
