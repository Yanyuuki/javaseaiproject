package com.yanyuuki.polymorphsm2;

public class Wolf extends Animal {
    String name="Wolf";
    @Override
    public void run(){
        System.out.println("Wolf runs rapidly...");
    }

    public void eat(){
        System.out.println("Wolf is eating meat...");
    }
}
