package me.farabiway.assignment;

import me.farabiway.assignment.productTypes.Food;
import java.sql.*;

public class ProductDAO {

    public void saveFood(Food food) {
        String sql = "INSERT INTO food (product_name, price, expiration_date, food_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, food.getProductName());
            pstmt.setInt(2, food.getPrice());
            pstmt.setString(3, food.getExpirationDate());
            pstmt.setString(4, food.getType().name());
            pstmt.executeUpdate();
            System.out.println("✅ Продукт '" + food.getProductName() + "' успешно добавлен в PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("❌ Ошибка при сохранении: " + e.getMessage());
        }
    }

    public void showAllFromDB() {
        String sql = "SELECT * FROM food ORDER BY id DESC";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- ТЕКУЩЕЕ СОСТОЯНИЕ ТАБЛИЦЫ В БД ---");
            while (rs.next()) {
                System.out.printf("[%d] %s | %d ₸ | Тип: %s\n",
                        rs.getInt("id"), rs.getString("product_name"), rs.getInt("price"), rs.getString("food_type"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
