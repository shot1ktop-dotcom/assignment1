package me.farabiway.assignment;

import me.farabiway.assignment.productTypes.Food;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    // CREATE (Write)
    public void saveFood(Food food) {
        String sql = "INSERT INTO food (product_name, price, expiration_date, food_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, food.getProductName());
            pstmt.setInt(2, food.getPrice());
            pstmt.setString(3, "2025-01-01"); // Accessor needed in your Food class
            pstmt.setString(4, food.getType().name());
            pstmt.executeUpdate();
            System.out.println("✅ Food saved to DB");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // READ
    public List<String> getAllFoodNames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT product_name FROM food";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                names.add(rs.getString("product_name"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return names;
    }

    // UPDATE
    public void updatePrice(String name, int newPrice) {
        String sql = "UPDATE food SET price = ? WHERE product_name = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newPrice);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("🔄 Price updated");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // DELETE
    public void deleteFood(String name) {
        String sql = "DELETE FROM food WHERE product_name = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("🗑️ Product deleted");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
