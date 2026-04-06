package com.yanyuuki.polymorphsm2;

public class Test {
    public static void main(String[] args) {
        //认识多态的代码
        //1.多态的好处1：右边对象是解耦合的
        Animal w = new Wolf();
        w.run();

        Animal t = new Tortoise();
        t.run();
        //t.shrinkHead();//报错，多态不能调用子类独有功能

        //2.多态好处2：父类类型变量作为参数，可以接受一个子类对象
        go(w);
        go(t);
    }

    //宠物游戏
    public static void go(Animal a){
        System.out.println(" Start ");
        a.run();
    }
}
