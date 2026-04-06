package com.yanyuuki.extends6constructor;

public class Test2 {
    public static void main(String[] args) {
        //子类构造器调用父类构造器的应用场景
        Teacher t=new Teacher("张三","java，c++",'男');
        System.out.println(t.getName()+"---"+t.getSkill()+"---"+t.getSex());
    }
}
