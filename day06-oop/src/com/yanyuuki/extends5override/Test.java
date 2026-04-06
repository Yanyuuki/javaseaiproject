package com.yanyuuki.extends5override;

public class Test {
    public static void main(String[] args) {
        //认识方法重写，在搞清楚场景
    }
}
class Cat extends Animal{
    //方法重写：方法名称，形参列表必须一样，这个方法就是方法重写
    //声明不变，重新实现
    @Override//方法重写的校验注解（标志注解）,要求方法名称和形参列表必须与被重写方法一致，否则报错,更安全，更优雅
    public void cry(){//重写方法访问权限必须大于等于父类方法的权限 ，重写返回值类型必须与被重写方法的返回值一样或范围更小
        System.out.println("喵喵喵");//私有方法和静态方法不能被重写，因为私有方法不能被继承,静态属于父类自己调用
    }
}
class Animal{
    public void cry(){
        System.out.println("动物叫");
    }
}
