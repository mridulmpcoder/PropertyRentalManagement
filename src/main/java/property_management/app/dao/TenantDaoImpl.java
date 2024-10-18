package property_management.app.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import property_management.app.entities.Tenant;

import java.util.List;

@Repository
public class TenantDaoImpl implements TenantDao {

    private final JdbcTemplate jdbcTemplate;

    public TenantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tenant getTenantByUserId(int userId) {
        String sql = "SELECT * FROM tenants WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Tenant.class));
    }

    @Override
    public List<Tenant> getAllTenants() {
        String sql = "SELECT * FROM tenants";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tenant.class));
    }

    @Override
    public void saveTenant(Tenant tenant) {
        String sql = "INSERT INTO tenants (tenant_type, no_of_person, tenant_status, created_at, updated_at, property_id, user_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tenant.getTenantType(), tenant.getNoOfPerson(), tenant.getTenantStatus(),
                tenant.getCreatedAt(), tenant.getUpdatedAt(), tenant.getPropertyId(), tenant.getUserId());
    }

    @Override
    public void updateTenant(Tenant tenant) {
        String sql = "UPDATE tenants SET tenant_type = ?, no_of_person = ?, tenant_status = ?, updated_at = ?, property_id = ? WHERE tenant_id = ?";
        jdbcTemplate.update(sql, tenant.getTenantType(), tenant.getNoOfPerson(), tenant.getTenantStatus(),
                tenant.getUpdatedAt(), tenant.getPropertyId(), tenant.getTenantId());
    }

    @Override
    public void deleteTenant(int tenantId) {
        String sql = "DELETE FROM tenants WHERE tenant_id = ?";
        jdbcTemplate.update(sql, tenantId);
    }
}
