package com.yanyuuki.javabean;

public class StudentService {
    //拿到要处理的学生对象
    private Student s;

    //有参构造器
    public StudentService(Student s){
        this.s = s;
    }

    //提供方法，打印学生对象总成绩
    public void printAllScore(){
        System.out.println(s.getName()+"的总成绩是："+(s.getChinese()+s.getMath()));
    }
    //提供方法，打印学生对象平均成绩
    public void printAvgScore(){
        System.out.println(s.getName()+"的平均成绩是："+(s.getChinese()+s.getMath())/2);
    }
}
