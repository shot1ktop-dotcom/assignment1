import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        
        Database.initDatabase();
        
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            
            server.createContext("/api/products", new ProductHandler());
            server.setExecutor(null);

            System.out.println("=================================================");
            System.out.println("✅ СЕРВЕР ЗАПУЩЕН: http://localhost:8080/api/products");
            System.out.println("=================================================");
            server.start();
        } catch (Exception e) {
            System.err.println("❌ Ошибка запуска сервера: " + e.getMessage());
        }
    }
}
