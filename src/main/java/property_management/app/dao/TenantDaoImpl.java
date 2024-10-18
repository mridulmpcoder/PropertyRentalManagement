package property_management.app.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import property_management.app.entities.Tenant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TenantDaoImpl implements TenantDao {

    private final JdbcTemplate jdbcTemplate;

    public TenantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tenant> getAllTenants() {
        String sql = "SELECT * FROM tenants";
        return jdbcTemplate.query(sql, new TenantRowMapper());
        
    }

    @Override
    public void assignTenantToProperty(int tenantId, int propertyId) {
        String sql = "INSERT INTO property_tenants (tenant_id, property_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, tenantId, propertyId);
    }

    @Override
    public void removeTenantFromProperty(int tenantId, int propertyId) {
        String sql = "DELETE FROM property_tenants WHERE tenant_id = ? AND property_id = ?";
        jdbcTemplate.update(sql, tenantId, propertyId);
    }
    
  
    private static class TenantRowMapper implements RowMapper<Tenant> {
        @Override
        public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tenant tenant = new Tenant();
            tenant.setTenantId(rs.getInt("tenant_id"));
            tenant.setTenantType(rs.getString("tenant_type"));
            tenant.setNoOfPerson(rs.getInt("no_of_person"));
            tenant.setTenantStatus(rs.getBoolean("tenant_status"));
            return tenant;
        }
    }
}
