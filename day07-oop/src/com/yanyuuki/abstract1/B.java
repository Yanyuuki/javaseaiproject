package com.yanyuuki.abstract1;
//一个类继承抽象类，必须重写继承类的全部抽象方法,否则也得定义为抽象类
public class B extends A{
    @Override
    public void show() {
        System.out.println("B show");
    }
}
