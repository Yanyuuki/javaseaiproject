package com.yanyuuki.loop;

public class BreakAndContinueDemo9 {
    public static void main(String[] args) {

        test1();
        System.out.print("\n");
        test2();

    }
    public static void test1(){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                break;
            }
            System.out.print(i);
        }
    }

    public static void test2(){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                continue;
            }
            System.out.print(i);
        }
    }
}
