package com.yanyuuki.interface1;

public interface A {
    //JDK 8 之前，接口中只能定义常量和抽象方法
    //1.常量：接口中定义常量可以省略public static final，默认会加
    String UNER_NAME="yanyuuki";
    //2.抽象方法：接口中定义抽象方法可以省略public abstract，默认会加
    void run();
    String go();
}
