package property_management.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import property_management.app.entities.Property;

public interface PropertyDao {

	int insertUser(Property property) throws IOException, SerialException, SQLException;

	public List<Property> getLatestProperties();

	public List<Property> getAllProperties();

	public List<Property> findProperties(String search, String location, List<String> facilities);

	public Optional<Property> findPropertyById(int propertyId);

	public List<String> findUniqueLocations();

}
