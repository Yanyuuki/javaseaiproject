package com.yanyuuki.abstract3;

public abstract class People {
    //1.模板方法设计模式
    public final void write(){
        System.out.println("\t\t\t我的爸爸");
        System.out.println("\t我的爸爸是一个优秀的人，他很爱帮助别人");
        //2.模板方法知道子类一定要写这个正文，但是每个子类写的信息是不用的，父类定义一个抽象方法
        //具体实现交给子类重写
        writeMain();
        System.out.println("\tparents are very good people, they love to help others.");
    }

    public abstract void writeMain();
}
