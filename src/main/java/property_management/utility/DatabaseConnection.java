package property_management.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// Method to establish and return a connection to the database
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL"); // Fetching DB URL from environment variable
		String username = System.getenv("DB_USERNAME"); // Fetching DB username from environment variable
		String password = System.getenv("DB_PASSWORD"); // Fetching DB password from environment variable

		if (url == null || username == null || password == null) {
			throw new SQLException("Database credentials are not set in environment variables");
		}

		return DriverManager.getConnection(url, username, password);
	}
}
