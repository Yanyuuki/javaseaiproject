package com.yanyuuki.staticmethod;
//静态方法设计工具类
public class VerifyCodeUtil {

    //工具类没有创建对象的必要性，所以建议将工具类构造器私有
    private VerifyCodeUtil(){}

    public static String getCode(int n){
        String code="";
        for(int i=0;i<n;i++){
            int type=(int)(Math.random()*3);//随机 数字 小写 大写
            switch (type) {
                case 0:
                    code += (int) (Math.random() * 10);
                    break;
                case 1:
                    code += (char) (Math.random() * 26 + 'a');
                    break;
                case 2:
                    code += (char) (Math.random() * 26 + 'A');
                    break;
                default:
                    break;

            }
        }
        return code;
    }

}
