import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:3306/traffic_db";
    static final String USER = "root";
    static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}