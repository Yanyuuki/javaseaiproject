package com.yanyuuki.abstract3;

public class Test {
    public static void main(String[] args) {
        //理解抽象类的使用场景之二：模板方法设计模式
        //学生和老师都要写一篇作文：（我的爸爸）
        //第一段是一样的：我的爸爸是一个优秀的人，他很爱帮助别人
        //第二段不一样：老师和学生写各自的
        //第三段一样的：parents are very good people, they love to help others.
        //解决：抽出一个父类模板
        Student s = new Student();
        s.write();

        Teacher t = new Teacher();
        t.write();

    }
}
