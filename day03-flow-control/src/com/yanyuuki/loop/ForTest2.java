package com.yanyuuki.loop;

import java.util.Scanner;

public class ForTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int num = sc.nextInt();
        System.out.println(sum(num));
    }
    public static int sum(int n){
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }
}
