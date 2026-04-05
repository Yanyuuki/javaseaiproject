package com.yanyuuki.thisdemo;

public class Test {
    //认识this关键字，搞清楚this关键字的应用场景
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1);
        s1.print();

        System.out.println("=====================");

        Student s2 = new Student();
        System.out.println(s2);
        s2.print();

        System.out.println("=====================");

        Student s3 = new Student();
        s3.name="蔡徐坤";
        s3.printHobby("唱跳rap篮球");
    }
}
