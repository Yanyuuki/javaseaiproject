package com.yanyuuki.staticmethod;

public class Test4 {
    //静态变量
    public static int count=0;
    //静态方法
    public static void printHelloWorld2(){
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
    }
    //实例变量
    private String name;
    //实例方法
    public void run(){}
    public static void main(String[] args) {
        //搞清楚静态方法和实例方法访问的几点注意事项
    }
    //1.静态方法中可以直接访问静态成员，不可以直接访问实例成员
    public static void printHelloWorld(){
        System.out.println("HelloWorld!");
        System.out.println(count);
        printHelloWorld2();
        //System.out.println(name);报错
        //run();报错
        //System.out.println(this);报错，this指的是当前对象，但是this不能单独使用，必须和成员变量一起使用
    }
    //2.实例方法中既可以直接访问静态成员，也可以直接访问实例成员
    public void go(){
        System.out.println(count);
        System.out.println(name);
        printHelloWorld();
        printHelloWorld2();
        run();
    }
    //3.实例方法中可以出现this关键字，但是静态方法中不可以出现this关键字
}
