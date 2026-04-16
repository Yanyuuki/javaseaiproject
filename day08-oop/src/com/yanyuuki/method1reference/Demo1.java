package com.yanyuuki.method1reference;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        //目标：静态方法引用
        test1();
    }
    public static void test1(){
        Student[] students=new Student[3];
        students[0]=new Student("张三",18,170,'男');
        students[1]=new Student("李四",20 ,180,'男');
        students[2]=new Student("王五",19,165,'女');
/*        Arrays.sort(students,new Comparator<Student>(){//Comparator透明暗示是一个函数接口，可以简化
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/

/*        Arrays.sort(students,(Student o1, Student o2) -> {
            return o1.getAge()-o2.getAge();
        });*/

    //    Arrays.sort(students,(o1, o2) ->o1.getAge() - o2.getAge());

        Arrays.sort(students, Student::compare);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
