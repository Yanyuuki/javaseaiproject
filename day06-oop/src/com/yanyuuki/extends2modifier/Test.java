package com.yanyuuki.extends2modifier;

public class Test {
    public static void main(String[] args) {
        //认识四种权限修饰符的修饰范围
        Fu ff=new Fu();
        //ff.privateMethod();同包下，不能访问私有的
        ff.defaultMethod();
        ff.protectedMethod();
        ff.publicMethod();
    }
}
