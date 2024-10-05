package property_management.app.dao;
 
import property_management.app.entities.PropertyManager;
import java.util.List;
 
public interface ManagerDao {
    
    public List<PropertyManager> getAllManagers();
    public void assignManagerToProperty(int propertyId, int managerId);
     
}
 