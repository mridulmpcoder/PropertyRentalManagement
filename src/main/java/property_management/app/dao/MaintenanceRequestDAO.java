package property_management.app.dao;

import property_management.app.entities.MaintenanceRequest;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public interface MaintenanceRequestDAO {

	public void saveRequest(MaintenanceRequest request) throws SQLException;
}