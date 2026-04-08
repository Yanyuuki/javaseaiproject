package com.yanyuuki.innerclass;

public class Outer {

    public static String schoolName="湖北大学";
    public static void test(){
        System.out.println("test方法执行了");
    }
    private int age=18;
    public void  run(){
        System.out.println("run方法执行了");
    }
    //成员内部类，无static修饰，属于外部类的对象持有的
    public class Inner{
        public void show(){
            System.out.println("show方法执行了");
            System.out.println("schoolName:"+schoolName);
            test();
            System.out.println("age:"+age);
            run();
            System.out.println("Inner.this:"+this);//自己的对象
            System.out.println("Outer.this:"+Outer.this);//外部类的对象
        }
    }

}
