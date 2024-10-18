package property_management.app.dao;

import java.util.List;

import property_management.app.entities.Manager;

public interface ManagerDao {
    List<Manager> getAllManagers();
    void approveManager(int managerId);
    void rejectManager(int managerId);
	List<Manager> getApprovedManagers();
	
}
