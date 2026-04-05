package com.yanyuuki.capsulation;

public class Test {
    //搞清楚封装的设计思想，合理隐藏合理暴露，学会如何隐藏如何暴露
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(18);
        System.out.println("年龄："+s1.getAge());
    }
}
