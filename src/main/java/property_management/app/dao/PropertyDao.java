package property_management.app.dao;



import property_management.app.model.Property;
import java.sql.SQLException;
import java.util.List;

public interface PropertyDao {
    static List<Property> getAllProperties() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
    void assignManager(String propertyId, String managerId) throws SQLException; // Implement this method
}
