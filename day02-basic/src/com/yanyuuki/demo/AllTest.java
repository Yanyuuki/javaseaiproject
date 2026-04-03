package com.yanyuuki.demo;

import java.util.Scanner;

public class AllTest {
    public static void main(String[] args) {
        //健康计算器
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = sc.nextInt();

        System.out.println("请输入性别(男/女)：");
        String sex = sc.next();

        System.out.println("请输入体重(单位kg)：");
        double weight = sc.nextDouble();

        System.out.println("请输入身高（单位m）：");
        double height = sc.nextDouble();

        double BMI=calBMI(weight,height);
        System.out.println("BMI:"+BMI);

        double BMR=calBMR(age,sex,weight,height);
        System.out.println("BMR:"+BMR+"kcal/天");
    }

    //计算BMI
    public static double calBMI(double weight,double height){
        double bmi = weight/(height*height);
        return bmi;
    }

    //计算BMR
    public static double calBMR(int age,String sex,double weight,double height){
        double bmr = 0;
        if(sex.equals("男")){
            bmr=10*weight+625*height-5*age+5;
        }
        else {
            bmr = 10 * weight + 625 * height - 5 * age - 161;
        }
        return bmr;
    }
}
