package property_management.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import property_management.app.entities.Property;

public interface PropertyDao {

	int insertUser(Property property) throws IOException, SerialException, SQLException;

	public List<Property> getAllProperties();

}
