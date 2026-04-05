package com.yanyuuki.object;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name="波妞";
        s1.chinese=100;
        s1.math=100;
        s1.printAllScore();
        s1.printAvgScore();
        System.out.println("------------------");
        Student s2 = new Student();
        s2.name="宗介";
        s2.chinese=50;
        s2.math=80;
        s2.printAllScore();
        s2.printAvgScore();
        System.out.println("------------------");
    }
}
