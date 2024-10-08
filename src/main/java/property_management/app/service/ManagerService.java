package property_management.app.service;


import java.sql.SQLException;
import java.util.List;

import property_management.app.model.Manager;

public interface ManagerService {
    List<Manager> getAllManagers() throws SQLException;
}
