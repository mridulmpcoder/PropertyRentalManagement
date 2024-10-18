package property_management.app.dao;
import property_management.app.entities.*;
import java.util.List;

public interface MaintenanceRequestDao {
    List<MaintenanceRequest> getAllRequests();
}
