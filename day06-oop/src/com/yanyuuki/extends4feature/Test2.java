package com.yanyuuki.extends4feature;

public class Test2 {
    public static void main(String[] args) {
        //继承后子类的访问特点：就近原则
        Zi z=new Zi();
        z.show();
        z.show2();

        System.out.println("------------------");
        Fu f=new Fu();
        f.show();
        f.show2();
    }
}
class Fu{
    String name="Fu's name";
    public void show(){
        System.out.println("Fu");
    }
    public void show2(){
        System.out.println(name);
    }
    public void run(){
        System.out.println("Fu's run");
    }
}
class Zi extends Fu{
    String name="Zi's name";
    public void show(){
        System.out.println("Zi");
    }
    public void show2(){
        System.out.println(this.name);
        System.out.println(super.name);
        run();
        super.run();
    }
    public void run(){
        System.out.println("Zi's run");
    }
}
