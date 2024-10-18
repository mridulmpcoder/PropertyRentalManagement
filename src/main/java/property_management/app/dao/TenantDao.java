package property_management.app.dao;

import property_management.app.entities.Tenant;

import java.util.List;

public interface TenantDao {
    Tenant getTenantByUserId(int userId);
    List<Tenant> getAllTenants();
    void saveTenant(Tenant tenant);
    void updateTenant(Tenant tenant);
    void deleteTenant(int tenantId);
}
