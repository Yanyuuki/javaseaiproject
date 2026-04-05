package com.yanyuuki.constructor;

public class Student {
    String name;
    int age;
    char sex;
    //1.无参数构造器
    //构造器：一种特殊的方法，不能写返回类型，名称必须是类名
    public Student(){
        System.out.println("===无参数构造器执行===");
    }

    //2.有参数构造器
    public Student(String n){
        System.out.println("===有参数String n构造器执行了===");
    }
    //构造器重载
    public Student(String name,int age,char sex){
        System.out.println("===有参数String n,int a,char s构造器执行了===");
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
}
