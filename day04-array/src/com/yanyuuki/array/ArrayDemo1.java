package com.yanyuuki.array;

public class ArrayDemo1 {
    public static void main(String[] args) {
        randomCall();
    }
    public static void randomCall(){
        //定义一个String数组,静态初始化数组
        String[] names =new String[]{"张三","李四","王五","赵六","小七","小八","小九","小十","小十一","小十二","小十三","小十四","小十五"};
        //随机获取一个索引值
        int index=(int)(Math.random()*names.length);
        System.out.println(names[index]);
    }
}
