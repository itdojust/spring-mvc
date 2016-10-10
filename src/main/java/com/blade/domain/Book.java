package com.blade.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 图书Bean
 */
// 忽略不知道的参数，解决@RequestBody请求json参数传递和本bean不匹配问题，直接忽略不会报错
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    public Book() {

    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private int id;

    private String name;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
