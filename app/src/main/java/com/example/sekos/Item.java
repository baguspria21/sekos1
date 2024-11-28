package com.example.sekos;

public class Item {

    private String name;
    private String price;
    private String description;
    private int imageResId;

    public Item(String name, int imageResId, String price) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
    public String getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
}
