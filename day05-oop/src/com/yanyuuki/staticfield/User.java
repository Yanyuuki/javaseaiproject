package com.yanyuuki.staticfield;

public class User {
    public static int cnt=0;
    public User(){//记录用户对象的个数
        cnt++;
        //同一个类中访问静态成员可以省略类名不写
        //User.cnt++;
    }
}
