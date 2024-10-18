package property_management.app.dao;
import org.springframework.jdbc.core.RowMapper;

import property_management.app.entities.Property;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyRowMapper implements RowMapper<Property> {
    @Override
    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
        Property property = new Property();
        property.setPropertyId(rs.getInt("PropertyID"));
        property.setTitle(rs.getString("Title"));
        property.setDescription(rs.getString("Description"));
       // property.setPrice(rs.getDouble("Price"));
        //property.setImage(rs.getBytes("ImageBlob")); // Assuming you store images as BLOB
        // Map other fields as necessary
        property.setLocation(rs.getString("City"));
       // property.setType(rs.getString("type")); // Assuming you have this field
        property.setSwimmingPool(rs.getBoolean("SwimmingPool")); // Map other facilities as necessary
        property.setGym(rs.getBoolean("Gym"));
        property.setParking(rs.getBoolean("Parking"));
        property.setGarden(rs.getBoolean("Garden"));
        property.setAirConditioning(rs.getBoolean("AirConditioning"));
        property.setElevator(rs.getBoolean("Elevator"));
        property.setSecuritySystem(rs.getBoolean("SecuritySystem"));
        property.setInternet(rs.getBoolean("Internet"));
        property.setFurnished(rs.getBoolean("Furnished"));
        return property;
    }
}

