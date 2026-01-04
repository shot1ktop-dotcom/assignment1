package me.farabiway.assignment;

import me.farabiway.assignment.model.Product;
import me.farabiway.assignment.objects.Inventory;
import me.farabiway.assignment.objects.Supplier;
import me.farabiway.assignment.productTypes.Electronics;
import me.farabiway.assignment.productTypes.Food;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Supplier supplier = new Supplier("+7 705 893 9039", "Alixan Bokeixan 76", "shot1ktop@gmail.com");
        System.out.println(supplier);
        Inventory inventory = new Inventory("Main Warehouse");

        inventory.addProduct(new Food("Potato", 170, "2025-07-07", Food.FoodType.VEGETABLE));
        inventory.addProduct(new Food("Apple", 200, "2025-07-07", Food.FoodType.FRUIT));
        inventory.addProduct(new Food("Coca-Cola", 600, "2028-09-05", Food.FoodType.JUICE));
        inventory.addProduct(new Food("Burger", 1500, "2025-12-01", Food.FoodType.FASTFOOD));
        inventory.addProduct(new Food("Snickers", 450, "2028-09-05", Food.FoodType.CANDY));

        inventory.addProduct(new Electronics("HP EliteDesk 800 G9", 700000,
                "2025-04-04", 5, Electronics.ElectronicsType.COMPUTER));
        inventory.addProduct(new Electronics("Asus VivoBook 15", 492000,
                "2025-04-12", 5, Electronics.ElectronicsType.LAPTOP));
        inventory.addProduct(new Electronics("iPhone 16 Pro Max", 799000,
                "2025-05-12", 5, Electronics.ElectronicsType.PHONE));
        inventory.addProduct(new Electronics("Samsung Neo QLED 8K", 3990000,
                "2025-01-01", 5, Electronics.ElectronicsType.TV));
        inventory.addProduct(new Electronics("LG UltraFine", 299000,
                "2025-05-12", 5, Electronics.ElectronicsType.MONITOR));
        inventory.addProduct(new Electronics("USB Docking Station", 7000,
                "2025-06-06", 5, Electronics.ElectronicsType.ACCESSORIES));

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
        Choose category:
        VEGETABLE, FRUIT, JUICE, FASTFOOD, CANDY
        LAPTOP, PHONE, ACCESSORIES, TV, MONITOR, COMPUTER
        """);

        String input = scanner.nextLine().toUpperCase();


        try {
            Food.FoodType foodType = Food.FoodType.valueOf(input);
            List<Food> foods = inventory.filterFoodByType(foodType);

            System.out.println("Available products:");
            for (Food f : foods) {
                System.out.println("- " + f.getProductName());
            }

        } catch (IllegalArgumentException e) {


            try {
                Electronics.ElectronicsType eType =
                        Electronics.ElectronicsType.valueOf(input);

                List<Electronics> electronics =
                        inventory.filterElectronicsByType(eType);

                System.out.println("Available products:");
                for (Electronics e1 : electronics) {
                    System.out.println("- " + e1.getProductName());
                }

            } catch (IllegalArgumentException ex) {
                System.out.println("❌ Invalid category");
                return;
            }
        }

        System.out.println("\nEnter product name:");
        String name = scanner.nextLine();

        Product selected = inventory.findByName(name);

        if (selected != null) {
            System.out.println("\n✅ Selection received:");
            System.out.println(selected);
        } else {
            System.out.println("\n❌ Product not found");
        }
    }
}
