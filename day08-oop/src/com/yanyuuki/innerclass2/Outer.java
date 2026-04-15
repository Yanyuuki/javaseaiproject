package com.yanyuuki.innerclass2;
//外部类
public class Outer {
    public static String schoolName="湖北大学";
    //静态内部类:属于外部类本身持有
    public static class Inner{
        private String name;
        public void show(){
            System.out.println("show方法执行了");
            System.out.println(schoolName);
            //静态内部类是否能直接访问外部类的实例对象？不可以！
        }

        public void setName(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }

    }

}
