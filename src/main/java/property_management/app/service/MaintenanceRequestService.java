package property_management.app.service;

import property_management.utility.DatabaseConnection;

import property_management.app.model.MaintenanceRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MaintenanceRequestService {

	// Method to submit a new maintenance request
	public void submitRequest(MaintenanceRequest request) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "INSERT INTO maintenance_request "
					+ "( request_type, description, photo, status) "
					+ "VALUES (?, ?, ?, ?)";

			statement = connection.prepareStatement(sql);
			//statement.setInt(1, request.getTenantId());
			statement.setString(1, request.getRequestType());
			statement.setString(2, request.getDescription());
			statement.setString(3, request.getPhotoUrl());
			statement.setString(4, "Pending"); // Default status for new requests

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement);
		}
	}

	// Method to retrieve all maintenance requests for a specific tenant
	public List<MaintenanceRequest> getRequestsByTenant(int tenantId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<MaintenanceRequest> requests = new ArrayList<>();

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM maintenance_request WHERE tenantId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, tenantId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				MaintenanceRequest request = new MaintenanceRequest();
				request.setRequestId(resultSet.getInt("request_id"));
				request.setTenantId(resultSet.getInt("tenantId"));
				request.setRequestType(resultSet.getString("request_type"));
				request.setDescription(resultSet.getString("description"));
				request.setPhotoUrl(resultSet.getString("photoUrl"));
				request.setStatus(resultSet.getString("status"));

				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement, resultSet);
		}

		return requests;
	}

	// Method to update the status of a maintenance request
	public void updateRequestStatus(int requestId, String status) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "UPDATE maintenance_request SET status = ? WHERE request_id = ?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, requestId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement);
		}
	}

	// Helper method to close the database resources
	private void closeResources(Connection connection, PreparedStatement statement) {
		try {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Helper method to close the database resources with ResultSet
	private void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
