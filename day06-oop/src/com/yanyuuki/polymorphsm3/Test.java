package com.yanyuuki.polymorphsm3;

public class Test {
    public static void main(String[] args) {
        //认识多态的代码
        //1.多态的好处1：右边对象是解耦合的
        Animal w = new Wolf();
        w.run();

        Animal t = new Tortoise();
        t.run();
        //t.shrinkHead();//报错，多态不能调用子类独有功能

        Tortoise tt=(Tortoise)t;//强制类型转换
        tt.shrinkHead();

        //有继承关系就可以强制类型转换，编译阶段不会报错
        //运行时可能会出现类型转换异常，运行阶段才会报错
        //Wolf ww=(Wolf)t;

        if(t instanceof Wolf){//判断真实类型
            Wolf ww=(Wolf)t;
        }
        else if(t instanceof Tortoise){
            Tortoise ttt=(Tortoise)t;
        }



        //2.多态好处2：父类类型变量作为参数，可以接受一个子类对象
        go(w);
        go(t);



    }

    //宠物游戏
    public static void go(Animal a){
        System.out.println(" Start ");
        a.run();

        if(a instanceof Wolf){//类型判断的应用
            Wolf w=(Wolf)a;
            w.eat();
        }
        else if(a instanceof Tortoise){
            Tortoise t=(Tortoise)a;
            t.shrinkHead();
        }
    }
}
