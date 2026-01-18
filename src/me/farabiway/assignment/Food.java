package me.farabiway.assignment.productTypes;


import me.farabiway.assignment.model.Product;
import java.util.Objects;

public class Food extends Product {

    private String expirationDate;
    private FoodType type;

    public Food(String productName, int price, String expirationDate, FoodType type) {
        super(productName, price);
        this.expirationDate = expirationDate;
        this.type = type;
    }

    // Геттеры необходимы для записи данных в БД через JDBC
    public String getExpirationDate() {
        return expirationDate;
    }

    public FoodType getType() {
        return type;
    }

    public enum FoodType {
        VEGETABLE, FRUIT, JUICE, FASTFOOD, CANDY
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + getProductName() + '\'' +
                ", price=" + getPrice() +
                ", expirationDate='" + expirationDate + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return Objects.equals(expirationDate, food.expirationDate) &&
                type == food.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationDate, type);
    }
}
