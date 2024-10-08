package property_management.app.service;

import property_management.app.dao.*;
import property_management.app.model.Manager;

import java.sql.SQLException;
import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public List<Manager> getAllManagers() throws SQLException {
        return ManagerDao.getAllManagers();
    }
}
