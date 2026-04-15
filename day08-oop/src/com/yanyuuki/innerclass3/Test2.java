package com.yanyuuki.innerclass3;

public class Test2 {
    public static void main(String[] args) {
        //目标：搞清楚匿名内部类的使用形式（语法），通常可以作为一个对象参数传输给对象使用
        //需求：学神，老师都要参加游泳比赛
        Swim s=new Swim(){
            @Override
            public void swimming() {
                System.out.println("老师游泳狗爬式");
            }
        };
        start(s);
        System.out.println("----------");
        start(new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生游泳蛙泳式");
            }
        });

    }

    //设计一个方法，可以接受老师和学生开始比赛
    public static void start(Swim s){
        System.out.println("开始游泳");
        s.swimming();
        System.out.println("结束游泳");
    }
}


/*class Teacher implements Swim{
    @Override
    public void swimming() {
        System.out.println("老师游泳狗爬式");
    }
}

class Student implements Swim{
    @Override
    public void swimming() {
        System.out.println("学生游泳蛙泳式");
    }
}*/

interface Swim{
    void swimming();
}
