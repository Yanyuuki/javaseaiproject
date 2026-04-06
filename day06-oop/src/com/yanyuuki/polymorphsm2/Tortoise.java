package com.yanyuuki.polymorphsm2;

public class Tortoise extends Animal {
    String name="Tortoise";
    @Override
    public void run(){
        System.out.println("Tortoise runs slowly...");
    }

    public void shrinkHead(){
        System.out.println("Tortoise shrinks head...");
    }
}
