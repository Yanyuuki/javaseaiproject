package com.yanyuuki.abstract1;

public class AbstractDemo1 {
    public static void main(String[] args) {
        //认识抽象类，抽象方法，搞清楚特点
        //抽象类的核心特点：有得有失（获得了抽象方法的能力，失去了创建对象的能力）
        //抽象类不能创建对象
        //A a = new A();报错
        //抽象类的使命就是被继承
        B b = new B();
        b.show();
        b.show1();
        b.setName("yanyuuki");
        System.out.println(b.getName());
        b.setAge(18);
        System.out.println(b.getAge());
    }
}
