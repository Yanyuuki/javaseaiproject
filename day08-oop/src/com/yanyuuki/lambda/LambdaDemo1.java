package com.yanyuuki.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        //目标：认识lambda表达式，搞清楚其基本作用
        Animal a = new Animal(){
            @Override
            public void cry() {
                System.out.println("喵喵喵");
            }
        };
        a.cry();

        //错误示范：lambda不可以简化全部匿名内部类，只能简化函数式接口的内部类
//        Animal a1 = ()->{
//            System.out.println("汪汪汪");
//        };

        System.out.println("=====================");

        Swim s1 =()->{
            System.out.println("游泳");
        };
        s1.swimming();
    }
}

abstract class Animal{
    public abstract void cry();
}

//函数式接口：只有一个抽象方法的接口
@FunctionalInterface//声明函数式接口
interface Swim{
    void swimming();
}