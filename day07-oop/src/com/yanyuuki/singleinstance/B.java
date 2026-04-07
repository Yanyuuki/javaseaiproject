package com.yanyuuki.singleinstance;

public class B {
    //2.定义静态变量
    private static B b;
    //1.私有化构造器
    private B(){}
    //提供静态方法返回对象
    public static B getInstance(){
        if(b==null){
            b=new B();
        }
        return b;
    }
}
