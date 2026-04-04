package com.yanyuuki.array;

import javax.swing.*;
import java.util.Scanner;

public class ArrayTest6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字：");
        int n=sc.nextInt();
        start(n);
    }
    public static void start(int n){
        int[][] arr=new int[n][n];

        int cnt=1;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=cnt++;
            }
        }

        printArray(arr);

        System.out.println();

        randomArray(arr);
    }
    //打印二维数组
    public static void printArray(int[][] arr){
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    //随机二维数组
    public static void randomArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int randomRow=(int)(Math.random()*arr.length);
                int randomCol=(int)(Math.random()*arr[i].length);
                int temp=arr[i][j];
                arr[i][j]=arr[randomRow][randomCol];
                arr[randomRow][randomCol]=temp;
            }
        }
        printArray(arr);
    }
}
