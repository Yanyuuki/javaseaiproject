package com.yanyuuki.extends5override;

public class Test2 {
    public static void main(String[] args) {
        //方法重写常见应用场景：子类重写object中的toString 方法，以便返回对象的内容
        Student s=new Student("张三",23,'男');
        System.out.println(s);//com.yanyuuki.extends5override.Student@23fc625e 所谓的地址
        //System.out.println(s.toString());
        //注意1：直接输出对象，默认会调用Object的toString方法，返回对象的地址信息
        //注意2：输出对象的地址实际上是没有什么意义的，开发中更希望输出对象时看对象的内容信息，所以子类要重写Object的toString方法
        //  以便输出对象时默认就近调用子类重写的toString方法返回对象的内容
    }
}
class Student{
    private String name;
    private int age;
    private char sex;

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
