package com.yanyuuki.staticmethod;

public class Test1 {
    public static void main(String[] args) {
        //认识static修饰和不修饰方法的区别
        //1.类名.静态方法(推荐)
        Student.printHelloWorld();

        //2.对象.静态方法(不推荐)
        Student s1 =new Student();
        s1.printHelloWorld();

        //3.对象名.实例方法
        //Student.printPass();
        s1.setScore(59);
        s1.printPass();

        //贵方，如果做了一个功能且不需要直接访问对象的数据，这个方法直接定义成静态方法
        //如果这个方法是对象的行为，需要访问对象的数据，这个方法必须定义成实例方法

        System.out.println("======================");
        printHelloWorld();//同属于Test类，可以省略类名Test不写调用静态方法printHelloWorld();
    }
    public static void printHelloWorld(){
        System.out.println("HelloWorld");
    }
}
