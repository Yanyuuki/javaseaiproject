package com.yanyuuki.finaldemo;

public class FinalDemo1 {
    //final修饰静态成员你变量
    //final修饰静态变量，这个变量今后称作常量，可以记住一个固定值，并且程序中不能修改了，通常这个值作为系统的配置信息
    //常量的名称，建议全部大写，多个单词用下划线隔开
    public static final String SCHOOL_NAME="湖北大学";

    //final 修饰实例变量
    private final String name="张三";

    public static void main(String[] args) {
        //认识final关键字的作用
        //3.final修饰变量，变量有且只能被复制一次
        /*
        变量有哪些呢？
        1.成员变量
            a.静态成员变量
            b.实例成员变量
        2.局部变量
         */
        final double rate=3.14;
        //rate=3.16;//第二次赋值，报错
    }
    public static void buy(final double z){
        System.out.println(z);
    }
}
//1.final修饰类，类不能被继承
final class A{}
//class B extends A{}

//2.final修饰方法，方法不能被重写
class C{
    final public void print(){
        System.out.println("HelloWorld");
    }
}
class D extends C{
    //public void print(){
    //    System.out.println("HelloWorld");
    //}
}
