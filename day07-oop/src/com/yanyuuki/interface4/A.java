package com.yanyuuki.interface4;

public interface A {
    //1.默认方法（普通实例方法）
    //默认用public修饰
    default void go(){
        System.out.println("A.go()");
        run();
    }

    //2.私有方法（JDK9新增）
    //私有的实例方法
    //如何调用？使用接口中的其他实例方法调用
    private void run(){
        System.out.println("A.run()");
    }

    //3.静态方法
    //默认用public修饰
    //如何调用？只能使用当前接口名调用
    static void show(){
        System.out.println("A.show()");
    }
}
