package property_management.app.dao;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import property_management.app.entities.PropertyManager;
 
import java.util.List;
 
@Repository
public class ManagerDaoImpl implements ManagerDao {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Override
    public List<PropertyManager> getAllManagers() {
        String sql = "SELECT * FROM managers";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new PropertyManager(
                        rs.getInt("manager_id"),
                        rs.getString("manager_name"),
                        rs.getString("manager_email"),
                        rs.getString("manager_phone")
                ));
    }
 
    @Override
    public void assignManagerToProperty(int propertyId, int managerId) {
        String sql = "UPDATE property SET manager_id = ? WHERE property_id = ?";
        jdbcTemplate.update(sql, managerId, propertyId);
    }
   
     
  
}
 