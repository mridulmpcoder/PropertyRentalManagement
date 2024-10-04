package property_management.app.dao;

import property_management.app.entities.Property;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyDaoImpl {

	private final JdbcTemplate jdbcTemplate;

	public PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Fetch all properties
	public List<Property> getAllProperties() {
	    String sql = "SELECT p.*, pt.TypeName AS type FROM Property p "
	               + "JOIN PropertyType pt ON p.PropertyTypeID = pt.PropertyTypeID";
	    return jdbcTemplate.query(sql, new PropertyRowMapper());
	}


	public List<Property> findProperties(String search, String city, String propertyType, Integer minCost,
			Integer maxCost, String facilities) {
		String sql = "SELECT p.*, pt.TypeName AS type " + "FROM Property p "
				+ "JOIN PropertyType pt ON p.PropertyTypeID = pt.PropertyTypeID " + "WHERE p.Title LIKE ? "
				+ "AND p.City LIKE ? " + "AND pt.TypeName LIKE ? " + "AND p.Price BETWEEN ? AND ?";

		System.out.println("Executing query: " + sql);
		System.out.println("Search: " + search + ", City: " + city + ", Property Type: " + propertyType + ", Min Cost: "
				+ minCost + ", Max Cost: " + maxCost);

		List<Property> properties = jdbcTemplate.query(sql, new PropertyRowMapper(), "%" + search + "%",
				"%" + city + "%", "%" + propertyType + "%", minCost, maxCost);

		System.out.println("Fetched Properties: " + properties);

		return properties;
	}

	// Method to find a property by its ID
	public Optional<Property> findPropertyById(int propertyId) {
	    String sql = "SELECT p.*, pt.TypeName AS type " + 
	                 "FROM Property p " +
	                 "JOIN PropertyType pt ON p.PropertyTypeID = pt.PropertyTypeID " + 
	                 "WHERE p.PropertyID = ?";

	    try {
	        Property property = jdbcTemplate.queryForObject(sql, new Object[] { propertyId }, new PropertyRowMapper());
	        return Optional.of(property); // Wrap the found property in an Optional
	    } catch (EmptyResultDataAccessException e) {
	        return Optional.empty(); // Return an empty Optional if no property is found
	    }
	}

	// Fetch unique cities for filters
	public List<String> findUniqueLocations() {
		String sql = "SELECT DISTINCT City FROM Property";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	// Fetch unique property types for filters
	public List<String> findUniquePropertyTypes() {
		String sql = "SELECT DISTINCT pt.TypeName " + "FROM Property p "
				+ "JOIN PropertyType pt ON p.PropertyTypeID = pt.PropertyTypeID";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	// Fetch unique facilities for filters
	public List<String> findUniqueFacilities() {
		String sql = "SELECT DISTINCT Facilities FROM Property";
		return jdbcTemplate.queryForList(sql, String.class);
	}
}
