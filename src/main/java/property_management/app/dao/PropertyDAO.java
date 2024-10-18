package property_management.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.jdbc.core.JdbcTemplate;

import property_management.app.entities.Property;

public interface PropertyDAO {

    int insertUser(Property property) throws IOException, SerialException, SQLException;

    List<Property> getLatestProperties();

    List<Property> getAllProperties();

    List<Property> findProperties(String search, String location, List<String> facilities);

    Optional<Property> findPropertyById(int propertyId);

    List<String> findUniqueLocations();

    // New method to fetch amount by tenant ID
    Double getAmountByTenantId(Long tenantId);
}
