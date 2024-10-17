package property_management.app.dao;

import property_management.app.entities.Property;

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
public class PropertyDaoImpl implements PropertyDao{
 
	private final JdbcTemplate jdbcTemplate;
 
	public PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 
	//Fetch the latest properties to display on the homepage
	public List<Property> getLatestProperties()
	{
		String sql = "SELECT p.*,pt.type_name AS type FROM property p "
					+ "JOIN property_type pt ON p.type_id = pt.type_id "
					+ "ORDER BY p.CreatedAt DESC LIMIT 5";
		return jdbcTemplate.query(sql, new PropertyRowMapper());
	}

 
	
	// Fetch all properties
	public List<Property> getAllProperties() {
	    String sql = "SELECT p.*, pt.type_name AS type FROM property p "
	               + "JOIN property_type pt ON p.type_id = pt.type_id";
	    return jdbcTemplate.query(sql, new PropertyRowMapper());
	}
 
 
	// Fetch properties based on search, location, and selected facilities
		public List<Property> findProperties(String search, String location, List<String> facilities) {
		    // Base query to fetch properties
		    StringBuilder sql = new StringBuilder(
		        "SELECT p.*, pt.type_name AS type FROM property p " +
		        "JOIN property_type pt ON p.type_id = pt.type_id " +
		        "WHERE (" +
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
		        if (facilities.contains("swimming_pool")) {
		            sql.append(" AND p.swimming_pool = 1");
		        }
		        if (facilities.contains("gym")) {
		            sql.append(" AND p.gym = 1");
		        }
		        if (facilities.contains("parking")) {
		            sql.append(" AND p.parking = 1");
		        }
		        if (facilities.contains("garden")) {
		            sql.append(" AND p.garden = 1");
		        }
		        if (facilities.contains("air_conditioning")) {
		            sql.append(" AND p.air_conditioning = 1");
		        }
		        if (facilities.contains("elevator")) {
		            sql.append(" AND p.elevator = 1");
		        }
		        if (facilities.contains("security_system")) {
		            sql.append(" AND p.SecuritySystem = 1");
		        }
		        if (facilities.contains("internet")) {
		            sql.append(" AND p.internet = 1");
		        }
		        if (facilities.contains("furnished")) {
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
	    String sql = "SELECT p.*, pt.type_name AS type " + 
	                 "FROM property p " +
	                 "JOIN property_type pt ON p.type_id = pt.type_id " + 
	                 "WHERE p.property_id = ?";
 
	    try {
	        Property property = jdbcTemplate.queryForObject(sql, new Object[] { propertyId }, new PropertyRowMapper());
	        return Optional.of(property); // Wrap the found property in an Optional
	    } catch (EmptyResultDataAccessException e) {
	        return Optional.empty(); // Return an empty Optional if no property is found
	    }
	}
 
	 // Fetch unique cities for the location dropdown
    public List<String> findUniqueLocations() {
        String sql = "SELECT DISTINCT City FROM Property";
        return jdbcTemplate.queryForList(sql, String.class);
    }
 
 
	@Override
	public int insertUser(Property property) throws IOException, SerialException, SQLException {
		Blob profileImage = getBlob(property.getpropertyImage());
 
		String query = "INSERT INTO property " + "(`title`, `description`, `location`, `type`, "
				+ "`price`, `swimmingPool`, `gym`, `parking`, "
				+ "`garden`, `airConditioning`, `elevator`, `securitySystem`, `internet`, `furnished`, `propertyImage`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
		return jdbcTemplate.update(query, property.getTitle(), property.getDescription(), property.getLocation(),
				property.getType(), property.getPrice(), property.isSwimmingPool(), property.isGym(),
				property.isParking(), property.isGarden(), property.isAirConditioning(), property.isElevator(), property.isSecuritySystem(), property.isInternet(), property.isFurnished() , profileImage);
	}
	private Blob getBlob(byte[] byteArr) throws IOException, SerialException, SQLException {
	    // Directly create a Blob from the byte array
	    Blob imageBlob = new SerialBlob(byteArr);
	    return imageBlob;
	}
}