package com.yanyuuki.enumdemo;

public class Test2 {
    public static void main(String[] args) {
        //枚举类的应用场景：做信息的分类和标志
        //需求：模拟上下左右移动图片
        //1.用常量做信息标志和分类，但参数值不受约束
        move1(Constant.UP);//还能接其他int类
        //2.用枚举做信息标志和分类，参数值收枚举类约束
        move2(Direction.UP);//只能接枚举对象
    }
    //枚举做法
    public static void move2(Direction direction){
        switch (direction){
            case Direction.UP:
                System.out.println("向上移动");
                break;
            case Direction.DOWN:
                System.out.println("向下移动");
                break;
            case Direction.LEFT:
                System.out.println("向左移动");
                break;
            case Direction.RIGHT:
                System.out.println("向右移动");
                break;
        }
    }


    //常量做法
    public static void move1(int direction){
        switch (direction){
            case Constant.UP:
                System.out.println("向上移动");
                break;
            case Constant.DOWN:
                System.out.println("向下移动");
                break;
            case Constant.LEFT:
                System.out.println("向左移动");
                break;
            case Constant.RIGHT:
                System.out.println("向右移动");
                break;
        }
    }
}
