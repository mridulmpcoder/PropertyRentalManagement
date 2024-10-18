package property_management.app.dao;


import java.util.List;

import property_management.app.entities.Tenant;
 
public interface TenantDao {
    List<Tenant> getAllTenants();
    void assignTenantToProperty(int tenantId, int propertyId);
    void removeTenantFromProperty(int tenantId, int propertyId);
}
 