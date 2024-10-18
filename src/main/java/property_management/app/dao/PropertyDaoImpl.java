package property_management.app.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import property_management.app.entities.Property;

@Repository
public class PropertyDaoImpl implements PropertyDao {
    private final JdbcTemplate jdbcTemplate;

    public PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM property";
        return jdbcTemplate.query(sql, new PropertyRowMapper());
    }

    @Override
    public Property getPropertyById(int propertyId) {
        String sql = "SELECT * FROM property WHERE property_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{propertyId}, new PropertyRowMapper());
    }

    @Override
    public void updateProperty(Property property) {
        String sql = "UPDATE property SET manager_id = ? WHERE property_id = ?";
        jdbcTemplate.update(sql, property.getManagerId(), property.getPropertyId());
    }
    @Override
    public void assignManagerToProperty(int managerId, int propertyId) {
        String sql = "UPDATE property SET manager_id = ? WHERE property_id = ?";
        jdbcTemplate.update(sql, managerId, propertyId);
    }

    @Override
    public void unassignManagerFromProperty(int propertyId) {
        String sql = "UPDATE property SET manager_id = NULL WHERE property_id = ?";
        jdbcTemplate.update(sql, propertyId);
    }
    
    private static class PropertyRowMapper implements RowMapper<Property> {
        @Override
        public Property mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            return new Property(
            );
        }
    }

}
