package com.yanyuuki.interface1;

public class Test {
    public static void main(String[] args) {
        //认识接口，搞清楚接口的特点,基本使用
        System.out.println(A.UNER_NAME);
        //注意：接口不能创建对象
        //A a=new A();报错
        C c=new C();
        c.run();
        System.out.println(c.go());
        c.play();
    }
}

//C称为实现类，同时实现多个接口
//实现类实现多个接口，必须重写全部接口的全部抽象方法，否则这个类必须定义为抽象类
class C implements A,B{

    @Override
    public void run() {
        System.out.println("C类正在运动");
    }

    @Override
    public String go() {
        return "String";
    }

    @Override
    public void play() {
        System.out.println("C类正在玩耍");
    }
}
