package com.yanyuuki.innerclass3;

import javax.swing.*;

public class Test3 {
    public static void main(String[] args) {
        //目标：搞清楚几个匿名内部类的使用场景
        //需求：创建一个登录窗口，窗口上只有一个登录按钮
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
