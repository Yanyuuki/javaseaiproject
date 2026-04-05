package com.yanyuuki.capsulation;

public class Student {
    //1.如何合理隐藏：使用private关键字修饰成员变量，就只能在本类中访问
    //其他任何地方不能直接访问
    String name;
    private int age;
    private double chinese;
    private double math;

    //2.如何合理暴露：使用public关键字修饰成员方法，其他任何地方都可以访问
    public void setAge(int age){//设置年龄
        if(age>0&&age<150){
            this.age=age;
        }
        else {
            System.out.println("年龄输入有误");
        }
    }
    public int getAge(){//获取年龄
        return this.age;
    }
    public void printAllScore(){
        System.out.println("姓名："+this.name+"，语文成绩："+this.chinese+"，数学成绩："+this.math);
        System.out.println("总成绩是："+(this.chinese+this.math));
    }
    public void printAvgScore(){
        System.out.println("姓名："+this.name+"，语文成绩："+this.chinese+"，数学成绩："+this.math);
        System.out.println("平均成绩是："+(this.chinese+this.math)/2);
    }
}
