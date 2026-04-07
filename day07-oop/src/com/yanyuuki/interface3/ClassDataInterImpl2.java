package com.yanyuuki.interface3;

public class ClassDataInterImpl2 implements ClassDataInter{

    private Student[] students;
    public ClassDataInterImpl2(Student[] students){
        this.students=students;
    }

    @Override
    public void printAllStudentInfos() {
        System.out.println("全班学生信息如下：");
        int maleCount=0;
        for(Student s:students){
            if(s.getSex()=='男'){
                maleCount++;
            }
            System.out.println(s);
        }
            System.out.println("男学生数："+maleCount);
            System.out.println("女学生数："+(students.length-maleCount));
    }

    @Override
    public void printAverageScore() {
        //去除最大值，最小值
        double sum=0;
        double mx=students[0].getScore();
        double mn=students[0].getScore();
        for (int i = 0; i < students.length; i++) {
            sum+=students[i].getScore();
            mx=Math.max(mx, students[i].getScore());
            mn=Math.min(mn, students[i].getScore());
        }
        System.out.println("平均分："+(sum-mx-mn)/(students.length-2));
    }
}
