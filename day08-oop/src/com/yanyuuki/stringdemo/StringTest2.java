package com.yanyuuki.stringdemo;

import java.util.Random;

public class StringTest2 {
    public static void main(String[] args) {
        // 目标：生成验证码
        String code = getCode(6);
        System.out.println("生成的验证码是：" + code);
    }

    // 帮我生成指定位数的随机验证码返回，每位可能是大小写字母或数字
    // 帮我用String变量记住全部要用的字符，随机生成验证码
    public static String getCode(int length) {
        if (length <= 0) {
            return "";
        }

        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            code.append(chars.charAt(index));
        }
        return code.toString();
    }
}

