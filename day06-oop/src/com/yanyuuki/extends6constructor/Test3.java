package com.yanyuuki.extends6constructor;

public class Test3 {
    public static void main(String[] args) {
        //理解this（...）调用兄弟构造器
        //创建对象，存储一个学生的数据
        Student s=new Student("张三",'男',18,"湖北大学");
        Student s2=new Student("李四",'男',19);
        System.out.println(s);
        System.out.println(s2);
    }
}
