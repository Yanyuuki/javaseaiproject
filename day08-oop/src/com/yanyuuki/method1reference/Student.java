package com.yanyuuki.method1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //姓名，年龄，身高，性别
    private String name;
    private int age;
    private double height;
    private char sex;

    public static int compare(Student s1, Student s2) {
        return s1.age - s2.age;
    }

    public int compareByHeight(Student s1, Student s2) {
        return Double.compare(s1.height, s2.height);
    }
}
