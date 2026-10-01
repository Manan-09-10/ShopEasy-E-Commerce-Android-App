package com.example.shopeasy;

public class Product {

    private int image;
    private String name;
    private String price;
    private float rating;

    public Product(int image, String name, String price, float rating) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }
}