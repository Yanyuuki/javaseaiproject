package com.yanyuuki.staticmethod;

public class Test2 {
    public static void main(String[] args) {
        //搞清楚静态方法的应用，可以做工具类
        //登录
        //开发一个验证码程序
        String code =VerifyCodeUtil.getCode(4);
        System.out.println(code);

        System.out.println(Math.random());//[0,1)
    }
}
