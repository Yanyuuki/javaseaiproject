package com.yanyuuki.singleinstance;
//设计成单例设计模式
public class A {
    //2.定义一个静态变量，用于基本本类的一个唯一对象,私有化/final防止外界修改唯一对象
    private static A a = new A();

    //1.私有化构造器：确保单例类对外不能创建太多对象，单例才有可能性
    private A(){}

    //3.提供一个公开的静态方法，返回这个对象的唯一对象
    public static A getInstance(){
        return a;
    }
}
