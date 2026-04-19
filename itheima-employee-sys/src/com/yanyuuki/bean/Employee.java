package com.yanyuuki.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String position;
    private String entryDate;
    private double salary;
    private String department;
}
