package com.yanyuuki.object;

public class Test1 {
    public static void main(String[] args) {
        //学会创建对象
        //类名 对象名 = new 类名();
        Star s1 = new Star();
        s1.name = "蔡徐坤";
        s1.age = 28;
        s1.gender = "男";
        s1.height = 184.0;
        s1.weight = 60.0;
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.gender);
        System.out.println(s1.height);
        System.out.println(s1.weight);
        System.out.println("------------------");
        Star s2 = new Star();
        s2.name = "王源";
        s2.age = 26;
        s2.gender = "男";
        s2.height = 168.0;
        s2.weight = 50.0;
        System.out.println(s2.name);
        System.out.println(s2.age);
        System.out.println(s2.gender);
        System.out.println(s2.height);
        System.out.println(s2.weight);
        System.out.println("------------------");
    }
}
