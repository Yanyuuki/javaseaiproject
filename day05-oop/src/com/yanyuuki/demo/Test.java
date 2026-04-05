package com.yanyuuki.demo;

public class Test {
    public static void main(String[] args) {
        //完成面向对象的综合小案例
        //1.设计电影类Movie，以便创建电影对象，封装电影数据
        //2.封装系统中的全部电影数据。（自己造 数据）
        Movie[] movies = new Movie[6];
        //name,price,id,actor
        movies[0] = new Movie("唐顿庄园", 9.5, 1, "唐·戴维森");
        movies[1] = new Movie("唐顿庄园2", 9.6, 2, "唐顿·维森");
        movies[2] = new Movie("唐顿庄园3", 9.7, 3, "唐顿·戴森");
        movies[3] = new Movie("唐顿庄园4", 9.8, 4, "唐顿·戴维");
        movies[4] = new Movie("唐顿庄园5", 9.9, 5, "顿·戴维森");
        movies[5] = new Movie("唐顿庄园6", 9.1, 6, "唐顿·戴维森");
        //3.创建电影操作对象，专门负责电影数据的业务处理
        MovieService mo=new MovieService(movies);
        mo.printAllMovies();
        mo.searchMovieById();
    }
}
