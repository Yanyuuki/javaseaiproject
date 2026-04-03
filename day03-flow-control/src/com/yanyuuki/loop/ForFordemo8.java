package com.yanyuuki.loop;

public class ForFordemo8 {
    public static void main(String[] args) {
        test1();
        tset2();
    }

    public static void test1(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i+j);
            }
            System.out.println("----------");
        }
    }
    public static void tset2(){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++) {
                System.out.print(j + "*" + i + "=" + i * j+" ");
            }
            System.out.println();
        }
    }
}
