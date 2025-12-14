package com.sweetshop.domain;

public class Sweet {

    private String id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Sweet(String id, String name, String category, double price, int quantity) {

    if (price < 0) {
        throw new IllegalArgumentException("Price cannot be negative");
    }

    if (quantity < 0) {
        throw new IllegalArgumentException("Quantity cannot be negative");
    }

    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
}
    public void purchase() {
    if (quantity <= 0) {
        throw new IllegalStateException("Sweet is out of stock");
    }
    quantity--;
}
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
