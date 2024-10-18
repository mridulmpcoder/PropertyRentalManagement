package property_management.app.dao;



import java.util.List;

import property_management.app.entities.Property;

public interface PropertyDao {
    List<Property> getAllProperties();
    Property getPropertyById(int propertyId);
    void updateProperty(Property property);
    
    void assignManagerToProperty(int managerId, int propertyId);
    void unassignManagerFromProperty(int propertyId);
}
