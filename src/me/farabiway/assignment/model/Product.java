package me.farabiway.assignment.model;

import java.util.Objects;

public abstract class Product {

    private String productName;
    private int price;

    protected Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productName + " | price: " + price + " ₸";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
