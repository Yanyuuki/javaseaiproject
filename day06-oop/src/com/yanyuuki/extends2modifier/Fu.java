package com.yanyuuki.extends2modifier;

public class Fu {
    //1.只能在当前类中访问
    private void privateMethod(){
        System.out.println("privateMethod()");
    }
    //2.只能在当前类，同一个包中的其他类
    void defaultMethod(){
        System.out.println("defaultMethod()");
    }
    //3.只能在当前类，同一个包中的其他类，子类中访问
    protected void protectedMethod(){
        System.out.println("protectedMethod()");
    }
    //4.可以在任何类中访问
    public void publicMethod(){
        System.out.println("publicMethod()");
    }

    public static void main(String[] args) {
        Fu f=new Fu();
        f.privateMethod();
        f.defaultMethod();
        f.protectedMethod();
        f.publicMethod();
    }
}
