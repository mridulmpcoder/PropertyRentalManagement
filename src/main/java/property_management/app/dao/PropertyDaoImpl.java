package property_management.app.dao;

import property_management.app.entities.Property;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

@Repository
public class PropertyDaoImpl implements PropertyDao {

	private final JdbcTemplate jdbcTemplate;

	public PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Double getAmountByTenantId(Long tenantId) {
	    String sql = "SELECT Price FROM property WHERE tenant_id = ?";
	    try {
			return jdbcTemplate.queryForObject(sql, new Object[]{tenantId}, Double.class);
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	// Fetch the latest properties to display on the homepage
	public List<Property> getLatestProperties() {
		String sql = "SELECT p.*,pt.type_name AS type FROM property p "
					+ "JOIN property_type pt ON p.type_id = pt.type_id "
		            + "WHERE p.status = 'active' " // Add this line
					+ "ORDER BY p.CreatedAt DESC LIMIT 5";
		

		return jdbcTemplate.query(sql, new PropertyRowMapper());
	}

	// Fetch all properties
	public List<Property> getAllProperties() {

	    String sql = "SELECT p.*, pt.type_name AS type FROM property p "
	               + "JOIN property_type pt ON p.type_id = pt.type_id"
	               + "WHERE p.status = 'active' "; // Add this line
	    return jdbcTemplate.query(sql, new PropertyRowMapper());

	}

	// Fetch properties based on search, location, and selected facilities
	public List<Property> findProperties(String search, String location, List<String> facilities) {
	    // Base query to fetch properties
	    StringBuilder sql = new StringBuilder(
	        "SELECT p.*, pt.type_name AS type FROM property p " +
	        "JOIN property_type pt ON p.type_id = pt.type_id " +
	        "WHERE p.status = 'active' AND (" + // Add this line
	        "p.title LIKE ? OR " +
	        "p.description LIKE ? OR " +
	        "p.city LIKE ? OR " +
	        "p.address LIKE ? OR " +    // Add more fields as needed
	        "p.state LIKE ? OR " +
	        "p.zip_code LIKE ?" +
	        ")"
	    );

	    // Add filtering based on the location
	    if (location != null && !location.isEmpty()) {
	        sql.append(" AND p.city LIKE ?");
	    }

	    // Add dynamic filtering based on facilities
	    if (facilities != null && !facilities.isEmpty()) {
	        if (facilities.contains("Swimming Pool")) {
	            sql.append(" AND p.swimming_pool = 1");
	        }
	        if (facilities.contains("Gym")) {
	            sql.append(" AND p.gym = 1");
	        }
	        if (facilities.contains("Parking")) {
	            sql.append(" AND p.parking = 1");
	        }
	        if (facilities.contains("Garden")) {
	            sql.append(" AND p.garden = 1");
	        }
	        if (facilities.contains("Air Conditioning")) {
	            sql.append(" AND p.air_conditioning = 1");
	        }
	        if (facilities.contains("Elevator")) {
	            sql.append(" AND p.elevator = 1");
	        }
	        if (facilities.contains("Security System")) {
	            sql.append(" AND p.security_system = 1");
	        }
	        if (facilities.contains("Internet")) {
	            sql.append(" AND p.internet = 1");
	        }
	        if (facilities.contains("Furnished")) {
	            sql.append(" AND p.furnished = 1");
	        }
	    }

	    // Prepare the search term with wildcards
	    String searchTerm = "%" + (search != null ? search : "") + "%";
	    List<Object> queryParams = new ArrayList<>();

	    // Add search parameters for multiple fields
	    queryParams.add(searchTerm);  // For Title
	    queryParams.add(searchTerm);  // For Description
	    queryParams.add(searchTerm);  // For City
	    queryParams.add(searchTerm);  // For Address
	    queryParams.add(searchTerm);  // For State
	    queryParams.add(searchTerm);  // For ZipCode

	    // Add location if specified
	    if (location != null && !location.isEmpty()) {
	        queryParams.add("%" + location + "%");
	    }

	    // Execute the query with the updated SQL and return the results
	    return jdbcTemplate.query(sql.toString(), new PropertyRowMapper(), queryParams.toArray());

	}

	// Method to find a property by its ID
	public Optional<Property> findPropertyById(int propertyId) {
		String sql = "SELECT p.*, pt.type_name AS type " + "FROM property p "
				+ "JOIN property_type pt ON p.type_id = pt.type_id " + "WHERE p.property_id = ?";

		try {
			Property property = jdbcTemplate.queryForObject(sql, new Object[] { propertyId }, new PropertyRowMapper());
			return Optional.of(property); // Wrap the found property in an Optional
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty(); // Return an empty Optional if no property is found
		}
	}

	// Fetch unique cities for the location dropdown
	public List<String> findUniqueLocations() {
		String sql = "SELECT DISTINCT city FROM property";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public Integer findPropertyIdByUserId(int userId) {
		String sql = "SELECT property_id FROM tenants WHERE user_id = ?";
		try {
			Integer propertyId = jdbcTemplate.queryForObject(sql, new Object[] { userId }, Integer.class);
			System.out.println("Property ID for User ID " + userId + ": " + propertyId);
			return propertyId;
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No property ID found for User ID " + userId);
			return null;
		}
	}

	@Override
	public int insertProperty(Property property) throws IOException, SerialException, SQLException {

		String query = "INSERT INTO property "
				+ "(title, description, type_id, price, status, flat_no, floor, location, city, state, zip_code, latitude, longitude, swimming_pool, gym, parking, "
				+ "garden, air_conditioning, elevator, security_system, internet, furnished, image) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		byte[] propertyImageBytes = null;
		if (property.getImage() != null && !property.getImage().isEmpty()) {
			try {
				propertyImageBytes = property.getImage().getBytes();
			} catch (IOException e) {
				e.printStackTrace(); // Handle exception appropriately in production
			}
		}

		// Ensure all fields match with the placeholders in the query
		return jdbcTemplate.update(query, property.getTitle(), property.getDescription(), property.getType_id(),
				property.getPrice(), property.getStatus(), property.getFlatNo(), property.getFloor(),
				property.getAddress(), // Added missing address field
				property.getCity(), // Added missing city field
				property.getState(), property.getZip_code(), property.getLatitude(), property.getLongitude(),
				property.isSwimmingPool(), property.isGym(), property.isParking(), property.isGarden(),
				property.isAirConditioning(), property.isElevator(), property.isSecuritySystem(), property.isInternet(),
				property.isFurnished(), propertyImageBytes); // Blob for property image
	}
    
    
//    @Override
//	public Double getAmountByTenantId(Long tenantId) {
//	    String sql = "SELECT Price FROM Property WHERE tenant_id = ?"; // Adjust based on the actual column name
//	    try {
//	        return jdbcTemplate.queryForObject(sql, new Object[]{tenantId}, Double.class);
//	    } catch (EmptyResultDataAccessException e) {
//	        return null; // Or handle this case as needed
//	    }
//	}
    
    
}