package com.yanyuuki.interface3;

public class ClassDataInterImpl1 implements ClassDataInter{

    private Student[] students;
    public ClassDataInterImpl1(Student[] students){
        this.students = students;
    }
    @Override
    public void printAllStudentInfos() {
        System.out.println("全班学生信息如下：");
        for(Student s:students){
            System.out.println(s);
        }
    }

    @Override
    public void printAverageScore() {
        double sum = 0;
        for(Student s:students){
            sum += s.getScore();
        }
        System.out.println("全班平均分是："+(sum/students.length));
    }
}
