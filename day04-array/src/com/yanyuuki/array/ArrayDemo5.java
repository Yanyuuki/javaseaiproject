package com.yanyuuki.array;

public class ArrayDemo5 {
    public static void main(String[] args) {
        printArray();
    }
    public static void printArray(){
        //二维数组，静态初始化
        String[][] classroom ={
                {"张三","李四","王五"},
                {"明日香","凌波丽","碇真嗣"},
                {"长期素食","千早爱音","咕咕嘎嘎","丰川祥子"},
                {"风灵高达","Gqux"}
        };

        //行索引
        String[] names=classroom[2];
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]+"\t");
        }

        //行索引,列索引
        System.out.println("\n"+classroom[1][1]);
        System.out.println(classroom[1][2]);

        //长度访问
        System.out.println(classroom.length);
        System.out.println(classroom[0].length);
        System.out.println(classroom[3].length);

        //遍历
        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length; j++) {
                System.out.print(classroom[i][j]+" ");
            }
            System.out.println();
        }

        //二维数组，动态初始化
        int[][] arr=new int[3][5];

        System.out.println();

        //随机
        randomArray(classroom);
    }
    public static void randomArray(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int randomRow=(int)(Math.random()*arr.length);
                int randomCol=(int)(Math.random()*arr[randomRow].length);
                String temp=arr[i][j];
                arr[i][j]=arr[randomRow][randomCol];
                arr[randomRow][randomCol]=temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
