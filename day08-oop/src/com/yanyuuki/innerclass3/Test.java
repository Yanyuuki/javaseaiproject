package com.yanyuuki.innerclass3;

public class Test {
    public static void main(String[] args) {
        //目标：认识匿名内部类，搞清楚其基本作用
        Animal a=new Animal(){
          @Override
          public void cry() {
              System.out.println("喵喵喵");
          }
        };//本质是一个子类对象
        a.cry();
    }
}

/*class Cat extends Animal{
    @Override
    public void cry() {
        System.out.println("喵喵喵");
    }
}*/