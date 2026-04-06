package com.yanyuuki.extends6constructor;

public class Test {
    public static void main(String[] args) {
        //认识子类构造器的特点，再看应用场景
        //子类构造器都会先调用父类的构造器，在执行自己的构造器
        Zi z=new Zi();//父类无参
        System.out.println("==========");
        Zi2 z2=new Zi2();//父类有参
        System.out.println("==========");
    }
}

class Fu{
    public Fu(){
        System.out.println("父类无参构造器");
    }
    public Fu(int a){
        System.out.println("父类有参构造器");
    }
}
class Zi extends Fu{
    public Zi(){
        //super();默认存在调取父类无参构造器
        System.out.println("子类无参构造器");
    }
}

class Fu2{
    private Fu2(){
        System.out.println("父类无参构造器");
    }
    public Fu2(int a){
        System.out.println("父类有参构造器");
    }
}
class Zi2 extends Fu2{
    public Zi2(){
        super(666);//调取父类有参构造器
        System.out.println("子类无参构造器");
    }
}