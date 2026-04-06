package com.yanyuuki.extends3modifier;

import com.yanyuuki.extends2modifier.Fu;

public class Demo {
    public static void main(String[] args) {
        Fu f=new Fu();
        //f.privateMethod();
        //f.defaultMethod();
        //f.protectedMethod();
        f.publicMethod();//其他包中只能访问public
    }
}
