package property_management.utility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 String dbUrl = System.getenv("DB_URL");
     String dbUser = System.getenv("DB_USER");
     String dbPassword = System.getenv("DB_PASSWORD");
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("dbUrl","dbUser","dbPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
