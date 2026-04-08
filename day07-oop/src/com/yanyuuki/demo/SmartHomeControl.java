package com.yanyuuki.demo;

import lombok.Getter;

public class SmartHomeControl {
    @Getter
    private static final SmartHomeControl instance = new SmartHomeControl();
    private SmartHomeControl(){}

    public void control(JD jd) {
        System.out.print("控制设备：" + jd.getName()+"\t\t当前状态：");
        if (jd.isOn()) {
            System.out.println("开");
        } else {
            System.out.println("关");
        }
        System.out.println("开始操作");
        jd.press();
        System.out.println("操作结束");
        System.out.println("设备状态"+((jd.isOn())?"开":"关"));
    }
}
