package me.farabiway.assignment;

import me.farabiway.assignment.objects.Inventory;
import me.farabiway.assignment.productTypes.Food;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Inventory inventory = new Inventory("Main Warehouse");
        Scanner scanner = new Scanner(System.in);

        // Наполняем локальный каталог разными категориями
        inventory.addProduct(new Food("Potato", 170, "2025-07-07", Food.FoodType.VEGETABLE));
        inventory.addProduct(new Food("Apple", 200, "2025-07-07", Food.FoodType.FRUIT));
        inventory.addProduct(new Food("Coca-Cola", 600, "2028-09-05", Food.FoodType.JUICE));
        inventory.addProduct(new Food("Burger", 1500, "2025-12-01", Food.FoodType.FASTFOOD));
        inventory.addProduct(new Food("Snickers", 450, "2028-09-05", Food.FoodType.CANDY));
        inventory.addProduct(new Food("Banana", 350, "2025-06-01", Food.FoodType.FRUIT));

        while (true) {
            System.out.println("\nВведите категорию для поиска (VEGETABLE, FRUIT, JUICE, FASTFOOD, CANDY) или 'EXIT':");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) break;

            try {
                // Превращаем текст в тип из Enum
                Food.FoodType selectedType = Food.FoodType.valueOf(input);

                // Фильтруем список в памяти
                List<Food> results = inventory.filterFoodByType(selectedType);

                if (results.isEmpty()) {
                    System.out.println("В категории " + input + " пока нет товаров.");
                } else {
                    System.out.println("\nНайдено в каталоге (" + input + "):");
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println((i + 1) + ". " + results.get(i).getProductName() + " [" + results.get(i).getPrice() + " ₸]");
                    }

                    System.out.println("\nВыберите номер товара, чтобы СОХРАНИТЬ его в базу данных (или 0):");
                    int choice = Integer.parseInt(scanner.nextLine());

                    if (choice > 0 && choice <= results.size()) {
                        Food selectedProduct = results.get(choice - 1);

                        // Сохраняем выбранный объект в БД
                        dao.saveFood(selectedProduct);

                        // Проверяем результат в БД
                        dao.showAllFromDB();
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Ошибка: Такой категории не существует.");
            } catch (Exception e) {
                System.out.println("❌ Ошибка ввода.");
            }
        }
        System.out.println("Программа завершена.");
    }
}
