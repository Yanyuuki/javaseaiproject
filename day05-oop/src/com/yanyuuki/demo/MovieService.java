package com.yanyuuki.demo;

import java.util.Scanner;

public class MovieService {
    private Movie[] movies;

    public MovieService(Movie[] movies) {
        this.movies = movies;
    }

    public void printAllMovies() {
        System.out.println("===----------===全部电影信息如下===----------===");
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            System.out.println(m.getId()+"---"+m.getName()+"---"+m.getPrice()+"---"+m.getActor());
        }
    }
    //根据id查询电影
    public void searchMovieById() {
        System.out.println("请输入要查询的id：");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            if (m.getId()==id) {
                System.out.println(m.getId()+"---"+m.getName()+"---"+m.getPrice()+"---"+m.getActor());
                return;
            }
        }
        System.out.println("没有此id对应的电影");
    }
}
