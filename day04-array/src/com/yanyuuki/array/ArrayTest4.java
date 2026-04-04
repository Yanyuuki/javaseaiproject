package com.yanyuuki.array;

public class ArrayTest4 {
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        //建牌
        String poker[]=new String[54];
        //建花色和数字
        String color[]={"♠","♥","♣","♦"};
        String numbers[]={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //遍历
        int index=0;
        for(int i=0;i<color.length;i++){
            for(int j=0;j<numbers.length;j++){
                poker[index]=color[i]+numbers[j];
                index++;
            }
        }
        poker[index]="小王";
        poker[index+1]="大王";

        //打印
        System.out.println("牌：");
        for(int i=0;i<poker.length;i++){
            System.out.print(poker[i]+" ");
            if((i+1)%13==0){
                System.out.println();
            }
        }

        //洗牌
        for(int i=0;i<54;i++){
            int index1=(int)(Math.random()* poker.length);
            String temp=poker[i];
            poker[i]=poker[index1];
            poker[index1]=temp;
        }
        System.out.println("洗牌后的牌：");
        for(int i=0;i<poker.length;i++){
            System.out.print(poker[i]+" ");
            if((i+1)%13==0){
                System.out.println();
            }
        }
    }
}
