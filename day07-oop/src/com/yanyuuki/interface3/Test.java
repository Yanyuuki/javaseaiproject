package com.yanyuuki.interface3;

public class Test {
    public static void main(String[] args) {
        //完成接口小案例
        //1.定义学生类，创建学生对象，封装学生数据，交给别人处理
        //2.准备学生数据,目前自己早一些测试数据
        Student[] allStudents = new Student[10];
        allStudents[0] = new Student("张三",'男',100);
        allStudents[1] = new Student("李四",'女',90);
        allStudents[2] = new Student("王五",'男',80);
        allStudents[3] = new Student("赵六",'女',70);
        allStudents[4] = new Student("孙七",'男',60);
        allStudents[5] = new Student("周八",'女',50);
        allStudents[6] = new Student("吴九",'男',40);
        allStudents[7] = new Student("郑十",'女',30);
        allStudents[8] = new Student("王十一",'男',20);
        allStudents[9] = new Student("张十二",'女',10);

        //3.提供两套业务实现方案，支持灵活切换（解耦合），面向接口编程
        //   -- 定义一个接口（规范思想），必须完成打印全班学生信息，打印平均分
        //   -- 定义第一套实现类，实现接口：打印学生信息，打印平均分
        //   -- 定义第二套实现类，实现接口：打印学生信息（男女人数），打印平均分（删去最高最低）
        ClassDataInter  cdi = new ClassDataInterImpl1(allStudents);
        cdi.printAllStudentInfos();
        cdi.printAverageScore();

        ClassDataInter  cdi2 = new ClassDataInterImpl2(allStudents);
        cdi2.printAllStudentInfos();
        cdi2.printAverageScore();
    }
}
