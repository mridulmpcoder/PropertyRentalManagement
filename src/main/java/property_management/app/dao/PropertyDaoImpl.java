package property_management.app.dao;


import property_management.app.model.Property;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyDaoImpl implements PropertyDao {
    // Database connection setup (use your own connection details)
	 private static final String URL = System.getenv("DB_URL");
	    private static final String USERNAME = System.getenv("DB_USERNAME");
	    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public List<Property> getAllProperties() throws SQLException {
        List<Property> properties = new ArrayList<>();
        String query = "SELECT id, name FROM properties"; // Adjust based on your DB structure

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Property property = new Property();
                property.setId(resultSet.getInt("id"));
                property.setName(resultSet.getString("name"));
                properties.add(property);
            }
        }
        return properties;
    }

    @Override
    public void assignManager(String propertyId, String managerId) throws SQLException {
        String query = "UPDATE properties SET manager_id = ? WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, managerId);
            preparedStatement.setString(2, propertyId);
            preparedStatement.executeUpdate();
        }
    }
}

