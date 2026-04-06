package com.yanyuuki.extends1demo;

public class Test {
    public static void main(String[] args) {
        Teacher t=new Teacher();
        t.setName("Yany_uki");
        t.setSkill("java,c++");
        t.setSex('男');
        System.out.println(t.getName()+"---"+t.getSkill()+"---"+t.getSex());

        Consultant c=new Consultant();
        c.setName("Yany_uki");
        c.setNumber(100);
        c.setSex('男');
        System.out.println(c.getName()+"---"+c.getNumber()+"---"+c.getSex());
    }
}
