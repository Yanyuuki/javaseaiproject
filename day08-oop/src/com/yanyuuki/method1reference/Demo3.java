package com.yanyuuki.method1reference;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        //目标：特定类型方法引用
        String[] names={"Andy","angela","Bob","Cindy","mike","dlei","Yanyuuki","jerry"};
        //Arrays.sort(names,(o1,o2)->o1.compareToIgnoreCase(o2));
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
