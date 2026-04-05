package com.yanyuuki.javabean;

public class Test {
    //搞清楚实体类是什么，搞清楚其基本作用和应用场景
    public static void main(String[] args) {
        //基本作用：创建它的对象，存取数据（封装数据）
        Student s1 = new Student();
        s1.setName("小七");
        s1.setChinese(100);
        s1.setMath(100);
        System.out.println(s1.getName()+"的语文成绩是："+s1.getChinese());
        System.out.println(s1.getName()+"的数学成绩是："+s1.getMath());

        //实体类在开发中的应用场景
        //实体类对象只负责数据的存取，而数据的业务处理交给其他类对象来完成，以实现数据和数据业务处理分离
        //分层思想

        //创建一个学生的操作对象，专门负责对学生对象的数据进行业务处理
        StudentService operation = new StudentService(s1);
        operation.printAllScore();
        operation.printAvgScore();
    }

}
