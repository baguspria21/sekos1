package com.example.sekos;

public class Kos {

    private String name;
    private String location;
    private String price;
    private int imageResId; // Resource ID for image

    public Kos(String name, String location, String price, int imageResId) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.imageResId = imageResId;
    }

    // Getter methods for each field
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }
}
