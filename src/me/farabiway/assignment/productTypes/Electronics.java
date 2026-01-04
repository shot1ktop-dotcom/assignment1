package me.farabiway.assignment.productTypes;

import me.farabiway.assignment.model.Product;
import java.util.Objects;

public class Electronics extends Product {

    private String manufactureDate;
    private int guaranteeYearCount;
    private ElectronicsType type;

    public Electronics(String productName, int price,
                       String manufactureDate,
                       int guaranteeYearCount,
                       ElectronicsType type) {
        super(productName, price);
        this.manufactureDate = manufactureDate;
        this.guaranteeYearCount = guaranteeYearCount;
        this.type = type;
    }

    public ElectronicsType getType() {
        return type;
    }

    public enum ElectronicsType {
        LAPTOP, PHONE, ACCESSORIES, TV, MONITOR, COMPUTER
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + getProductName() + '\'' +
                ", price=" + getPrice() +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", guaranteeYears=" + guaranteeYearCount +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Electronics that = (Electronics) o;
        return guaranteeYearCount == that.guaranteeYearCount &&
                Objects.equals(manufactureDate, that.manufactureDate) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufactureDate, guaranteeYearCount, type);
    }
}
