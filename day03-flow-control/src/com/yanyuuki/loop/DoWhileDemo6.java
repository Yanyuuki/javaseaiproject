package com.yanyuuki.loop;

public class DoWhileDemo6 {
    public static void main(String[] args) {
        test1();
    }
    public static  void test1(){
        int i=0;
        do{
            System.out.println(i);
            i++;
        }while(false);
    }
}
