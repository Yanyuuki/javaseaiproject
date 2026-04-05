package com.yanyuuki.staticfield;

public class Test1 {
    //认识static修饰成员变量，特点，访问机制，搞清楚作用
    public static void main(String[] args) {
        //1.类名.静态变量(推荐)
        Student.name="袁华";
        System.out.println(Student.name);

        //2.对象名.静态变量(不推荐)
        Student s1 = new Student();
        s1.name = "马冬梅";

        Student s2 = new Student();
        s2.name = "秋雅";

        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(Student.name);

        //3.对象名.实例对象
        s1.age=23;
        s2.age=18;
        System.out.println(s1.age);
        System.out.println(s2.age);
    }
}
