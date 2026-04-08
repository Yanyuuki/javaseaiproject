package com.yanyuuki.code;

public class CodeDemo2 {


    private String[] direction=new String[4];
    private String name;
    //实例代码块，无static修饰，属于对象，每次创建对象时，都会优先执行一次
    //基本作用，初始化对象的实例资源
    {
        System.out.println("实例代码块");
        name = "张三";
        direction[0]="东";

        direction[1]="南";

        direction[2]="西";

        direction[3]="北";

    }


    public static void main(String[] args) {
        System.out.println("main方法执行了");
        new CodeDemo2();
        new CodeDemo2();
        new CodeDemo2();
    }
}
