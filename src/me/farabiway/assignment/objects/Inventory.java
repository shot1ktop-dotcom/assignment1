package me.farabiway.assignment.objects;

import me.farabiway.assignment.model.Product;
import me.farabiway.assignment.productTypes.Electronics;
import me.farabiway.assignment.productTypes.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {

    private String name;
    private List<Product> assortment = new ArrayList<>();

    public Inventory(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        assortment.add(product);
    }


    public List<Food> filterFoodByType(Food.FoodType type) {
        List<Food> result = new ArrayList<>();
        for (Product p : assortment) {
            if (p instanceof Food) {
                Food f = (Food) p;
                if (f.getType() == type) {
                    result.add(f);
                }
            }
        }
        return result;
    }


    public List<Electronics> filterElectronicsByType(Electronics.ElectronicsType type) {
        List<Electronics> result = new ArrayList<>();
        for (Product p : assortment) {
            if (p instanceof Electronics) {
                Electronics e = (Electronics) p;
                if (e.getType() == type) {
                    result.add(e);
                }
            }
        }
        return result;
    }


    public Product findByName(String name) {
        for (Product p : assortment) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", totalProducts=" + assortment.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(name, inventory.name) &&
                Objects.equals(assortment, inventory.assortment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, assortment);
    }
}
