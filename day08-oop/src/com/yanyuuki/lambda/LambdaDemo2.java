package com.yanyuuki.lambda;

import com.yanyuuki.innerclass3.Student;

import javax.swing.*;
import java.util.Arrays;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //目标：用lambda表达式简化实际案例
        test1();
        test2();

    }
    public static void test1(){
        Student[] students=new Student[3];
        students[0]=new Student("张三",18,170,'男');
        students[1]=new Student("李四",20 ,180,'男');
        students[2]=new Student("王五",19,165,'女');
/*        Arrays.sort(students,new Comparator<Student>(){//Comparator透明暗示是一个函数接口，可以简化
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/

/*        Arrays.sort(students,(Student o1, Student o2) -> {
            return o1.getAge()-o2.getAge();
        });*/

        Arrays.sort(students,(o1,o2) ->o1.getAge() - o2.getAge());

        for (Student student : students) {
            System.out.println(student);
        }
    }
    public static void test2(){
        JFrame win = new JFrame("登录窗口");
        win.setSize(300,200);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("登录");
        panel.add(btn);

        //java要求必须给按钮添加一个点击事件监听器对象,这样就可以监听用户的点击操作,就可以做出反应
        /*btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("点击了登录按钮");
            }
        });*/
        btn.addActionListener(e -> System.out.println("点击了登录按钮"));

        win.setVisible(true);
    }
}
