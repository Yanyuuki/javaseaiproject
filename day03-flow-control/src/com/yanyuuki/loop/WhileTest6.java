package com.yanyuuki.loop;

public class WhileTest6 {
    public static void main(String[] args) {
        System.out.println(calc());
    }
    public static int calc(){
        double paperThickness=0.1;
        double peakHeight=8848860;
        int count=0;
        while(paperThickness<peakHeight){
            paperThickness*=2;
            count++;
        }
        return count;
    }
}
