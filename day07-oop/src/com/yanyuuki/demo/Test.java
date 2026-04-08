package com.yanyuuki.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //面向对象编程实现只能家具控制系统
        //角色：设备（吊灯，电视机，洗衣机，落地窗。。。）
        //具备的功能：开和关
        //谁控制他们：智能控制系统（单例对象），控制调用设备的开和关
        //1.定义设备类：创建设备对象代表家里设备
        //2.准备这些设备对象，放在数组中，代表整个家庭的设备

        JD[] jds = new JD[4];
        jds[0]=new TV("小米电视",true);
        jds[1]=new WashMachine("美的洗衣机",false);
        jds[2]=new Lamp("欧莱雅灯泡",true);
        jds[3]=new Air("美的空调",false);

        //3.为每个设备指定一个开和关的功能,定义一个接口Switch
        //4.创建只能控制系统对象，控制设备开关
        SmartHomeControl sc = SmartHomeControl.getInstance();
        //5.控制电视机
        //sc.control(jds[0]);

        Scanner c=new Scanner(System.in);
        //6.提示用户操作：a。展示所有设备情况。b。选择设备进行操作。c。退出系统
        while(true){
            System.out.println("a.展示所有设备情况");
            System.out.println("b.选择设备进行操作");
            System.out.println("c.退出系统");
            String choice = c.next();
            switch(choice){
                case "a":
                    for(JD jd:jds){
                        System.out.println(jd);
                    }
                    break;

                case "b":
                    System.out.println("请输入设备编号：");
                    int index = c.nextInt();
                    sc.control(jds[index]);
                    break;

                case "c":
                    System.out.println("退出系统");
                    return;

                default:
                    System.out.println("输入错误");
            }
        }
    }
}
