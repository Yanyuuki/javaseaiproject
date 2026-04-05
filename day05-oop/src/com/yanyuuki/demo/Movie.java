package com.yanyuuki.demo;

public class Movie {
    private String name;
    private double price;
    private int id;
    private String actor;

    public Movie() {
    }

    public Movie(String name, double price, int id, String actor) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
