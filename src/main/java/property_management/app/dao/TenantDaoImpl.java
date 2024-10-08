package property_management.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import property_management.app.model.Tenant;

public class TenantDaoImpl implements TenantDao {
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    @Override
    public void addTenant(Tenant tenant) throws SQLException {
        String sql = "INSERT INTO tenants (first_name,last_name,email,Contact, lease_start, lease_expiry) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, tenant.getFirstName());
            pstmt.setString(1, tenant.getLastName());
            pstmt.setString(2, tenant.getEmail());
            pstmt.setString(3, tenant.getContact());
            pstmt.setDate(4, tenant.getLeaseStart());
            pstmt.setDate(5, tenant.getLeaseExpiry());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteTenant(int tenantId) throws SQLException {
        String sql = "DELETE FROM tenants WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tenantId);
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Tenant> getAllTenants() throws SQLException {
        List<Tenant> tenantList = new ArrayList<>();
        String sql = "SELECT * FROM tenants";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Tenant tenant = new Tenant();
                tenant.setId(rs.getInt("id"));
                tenant.setFirstName(rs.getString("firstName"));
                tenant.setLastName(rs.getString("lastName"));
                tenant.setEmail(rs.getString("email"));
                tenant.setContact(rs.getString("MobileNo"));
                tenant.setLeaseStart(rs.getDate("lease_start"));
                tenant.setLeaseExpiry(rs.getDate("lease_expiry"));
                tenantList.add(tenant);
            }
        }
        return tenantList;
    }

	public static void save(Tenant tenant) {
		// TODO Auto-generated method stub
		
	}
}
