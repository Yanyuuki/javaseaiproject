package com.yanyuuki.constructor;
//构造器作用：初始化数据，分配空间
//类默认自带无参构造器
//写了有参构造器，则自带无参构造器消失
public class Test {
    public static void main(String[] args) {
        //认识类的构造器，搞清楚其特点和常见应用场景
        //创建类的时候自动调用构造器
        Student s1 = new Student();//调用无参数构造器
        Student s2 = new Student("鸟谷真琴");//调用有参数构造器

        System.out.println("======================");

        Student t1=new Student();
        t1.name="河源木桃香";
        t1.age=18;
        t1.sex='女';
        System.out.println(t1.name+"，"+t1.age+"，"+t1.sex);

        System.out.println("======================");

        Student t2=new Student("小七",18,'女');
        System.out.println(t2.name+"，"+t2.age+"，"+t2.sex);
    }
}
