package property_management.app.dao;


import java.sql.SQLException;
import java.util.List;

import property_management.app.model.Tenant;

public interface TenantDao {
    void addTenant(Tenant tenant) throws SQLException;
    void deleteTenant(int tenantId) throws SQLException;
    List<Tenant> getAllTenants() throws SQLException;
}
