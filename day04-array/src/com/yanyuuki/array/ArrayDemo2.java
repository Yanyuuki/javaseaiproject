package com.yanyuuki.array;

import java.util.Scanner;

public class ArrayDemo2 {
    public static void main(String[] args) {
        inputScore();
    }
    public static void inputScore(){
        //动态初始化数组
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int n=sc.nextInt();
        double score[]=new double[n];//开辟动态空间
        for (int i = 0; i < score.length; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的成绩");
            score[i]=sc.nextDouble();
        }
        double sum=0;
        double mn=101;
        double mx=0;
        double avg=0;
        for (int i = 0; i < score.length; i++) {
            mn=Math.min(mn, score[i]);//计算最小值
            mx=Math.max(mx, score[i]);//计算最大值
            sum+=score[i];//求和
        }
        avg=sum/score.length;
        System.out.println("平均分是："+avg);
        System.out.println("最高分是："+mx);
        System.out.println("最低分是："+mn);
    }
}
