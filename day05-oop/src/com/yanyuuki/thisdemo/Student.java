package com.yanyuuki.thisdemo;

public class Student {
    String name;
    public void print(){
        //this是一个变量，同在方法中，用于拿到当前的对象
        //哪个对象调用这个方法，this就拿到哪个对象
        System.out.println("this:"+this);
    }

    public void printHobby(String name){
        System.out.println(this.name+"喜欢"+name);//解决变量名称冲突的问题
    }
}
