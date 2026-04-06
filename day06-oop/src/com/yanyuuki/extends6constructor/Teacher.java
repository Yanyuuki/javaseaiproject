package com.yanyuuki.extends6constructor;

public class Teacher extends People {
    private String skill;

    public Teacher() {}

    public Teacher(String name, String skill, char sex) {
        this.skill=skill;
        super(name,sex);
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
