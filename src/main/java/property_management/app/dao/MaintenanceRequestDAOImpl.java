package property_management.app.dao;


import property_management.app.entities.MaintenanceRequest;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class MaintenanceRequestDAOImpl implements MaintenanceRequestDAO {

	private final JdbcTemplate jdbcTemplate;

	public MaintenanceRequestDAOImpl(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;

	}

	public void saveRequest(MaintenanceRequest request) throws SQLException {

		String sql = "INSERT INTO maintenance_request " + "(request_type, description, photo, user_id ) " +

				"VALUES (?, ?, ?, 2)";

		// Using JdbcTemplate to execute the insert
		try {

			jdbcTemplate.update(sql,

					request.getRequestType(),

					request.getDescription(),

					request.getPhoto() // Assuming photo is of type byte[]

			);

		} catch (Exception e) {

			// Handle any exceptions that may occur

			throw new SQLException("Error saving maintenance request: " + e.getMessage(), e);

		}

	}

}
