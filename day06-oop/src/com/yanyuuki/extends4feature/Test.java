package com.yanyuuki.extends4feature;

public class Test {
    public static void main(String[] args) {
        A a = new A();

    }
}
//1.java中的类只能是单继承的，不支持多继承，支持多层继承
//2.一个类要么直接继承object，要么默认继承object，要么间接继承object
class A{
}
class B extends A{
}
class C extends B{
}

