package com.yanyuuki.interface2;

public class Test {
    public static void main(String[] args) {
        //去理解java设计接口的好处，用处
        //弥补了类单继承的不足，可以让类拥有更多角色，类的功能更加强大
        Prople p = new Student();
        Driver d = new Student();
        Boyfriend b = new Student();

        //接口可以实现面向接口编程，更利于解耦合
        Driver d1 = new Teacher();//new Student();
    }
}

interface Driver{}
interface Boyfriend{}

class Prople{}
class Student extends Prople implements Driver,Boyfriend{}

class Teacher implements Driver,Boyfriend{}
