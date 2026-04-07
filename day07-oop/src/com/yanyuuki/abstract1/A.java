package com.yanyuuki.abstract1;
//抽象类
public abstract class A {
    private String name;
    private int age;

    public A() {}

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //抽象方法，必须用abstract修饰，抽象方法没有方法体，只有方法声明，抽象方法必须定义在抽象类中
    public abstract void show();

    public void show1(){
        System.out.println("show1");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
