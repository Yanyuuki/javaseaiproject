package com.yanyuuki.gui;

import javax.swing.*;

public class JFrameDemo1 {
    public static void main(String[] args) {
        JFrame jf=new JFrame("这是一个窗口");

        JPanel panel=new JPanel();
        jf.add(panel);

        jf.setSize(400,300);//设置窗口大小
        jf.setLocationRelativeTo(null);//设置窗口居中
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时退出程序

        JButton jbt=new JButton("登录");
        panel.add(jbt);

        jf.setVisible(true);//设置窗口可见
    }
}
