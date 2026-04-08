package com.yanyuuki.innerclass;

public class InnerClassDemo1 {

    public static void main(String[] args) {
        //搞清楚成员内部类的语法
        //外部类名称.内部类名称 对象名=new 外部类名称().new 内部类名称();
        Outer.Inner i1 = new Outer().new Inner();
        i1.show();
        //成员内部类访问外部类成员的特点（拓展）
        //1.成员内部类中可以直接访问你外部类的静态成员,也可以直接访问外部类的实例成员
        //2.成员内部类的实例方法中，可以直接拿到当前俺寄生的外部类对象：外部类名.this

        People.Heart p=new People().new Heart();
        p.show();
    }

}

class People{
    private int heartbeat=100;

    public class Heart{
        private int heartbeat=200;
        public void show(){
            int heartbeat=300;
            System.out.println("heartbeat:"+heartbeat);
            System.out.println("Heart.heartbeat:"+this.heartbeat);
            System.out.println("People.heartbeat:"+People.this.heartbeat);
        }
    }
}
