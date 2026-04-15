package com.yanyuuki.innerclass3;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {
    public static void main(String[] args) {
        //目标：完成给数组排序，理解其中匿名内部类的用法
        //准备一个学生类型的数组，存放6歌学生对象
        Student[] students=new Student[6];
        students[0]=new Student("小王",18,170,'男');
        students[1]=new Student("小张",19,160,'女');
        students[2]=new Student("小李",17,165,'男');
        students[3]=new Student("小赵",16,160,'女');
        students[4]=new Student("小孙",18,170,'男');
        students[5]=new Student("小周",19,160,'女');

        //需求，按照年龄升序排序，乐意调用sun公司写好的API直接对数组进行排序
        //public static void sort(T[] a, Comparator<T> c)
        //           参数一：需要排序的数组
        //           参数二：需要给sort声明一个Comparator比较器对象，指定排序规则
        //     sort方法会调用匿名内部类对象的compare方法，对数组中的学生对象进行两两比较
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //指定排序规则
                //如果你认为左边对象 大于 右边对象，返回正整数
                //如果你认为左边对象 小于 右边对象，返回负整数
                //如果认为两边对象相等，返回0
                /*if(o1.getAge()>o2.getAge()){
                    return 1;
                }else if(o1.getAge()<o2.getAge()){
                    return -1;
                }
                return 0;*/
                return o1.getAge()-o2.getAge();
            }
        });

        //遍历学生对象
        for(Student s:students){
            System.out.println(s);
        }
    }
}
