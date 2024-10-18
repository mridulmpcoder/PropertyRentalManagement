package property_management.app.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import property_management.app.entities.MaintenanceRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MaintenanceRequestDaoImpl implements MaintenanceRequestDao {
    
    private final JdbcTemplate jdbcTemplate;

    public MaintenanceRequestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MaintenanceRequest> getAllRequests() {
        String sql = "SELECT * FROM maintenance_request";
        return jdbcTemplate.query(sql, new MaintenanceRequestRowMapper());
    }

    private static class MaintenanceRequestRowMapper implements RowMapper<MaintenanceRequest> {
        @Override
        public MaintenanceRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
            MaintenanceRequest request = new MaintenanceRequest();
            request.setMaintenanceId(rs.getInt("maintenance_id"));
            request.setRequestType(rs.getString("request_type"));
            request.setDescription(rs.getString("description"));
            request.setPhoto(rs.getBytes("photo"));
            request.setStatus(rs.getString("status"));
            request.setUserId(rs.getInt("user_id"));
            request.setManagerId(rs.getInt("manager_id"));
            request.setTenantId(rs.getInt("tenant_id"));
            request.setRequestedDate(rs.getTimestamp("requested_date"));
            request.setResolvedDate(rs.getTimestamp("resolved_date"));
            request.setFinalCost(rs.getBigDecimal("final_cost"));
            return request;
        }
    }
}
