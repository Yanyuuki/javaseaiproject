package com.yanyuuki.object;
//学生类
public class Student {
    String name;
    double chinese;
    double math;

    public void printAllScore(){
        System.out.println("姓名："+name+"，语文成绩："+chinese+"，数学成绩："+math);
        System.out.println("总成绩是："+(chinese+math));
    }
    public void printAvgScore(){
        System.out.println("姓名："+name+"，语文成绩："+chinese+"，数学成绩："+math);
        System.out.println("平均成绩是："+(chinese+math)/2);
    }
}
