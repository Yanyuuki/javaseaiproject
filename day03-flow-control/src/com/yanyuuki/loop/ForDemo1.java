package com.yanyuuki.loop;

public class ForDemo1 {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        for(int i=0;i<3;i++){
            System.out.println("Hello,World!");
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("yanyuuki");
        }
        for (int i = 0; i < 3; i+=2) {
            System.out.println("fori");//快捷键
        }
    }
}
