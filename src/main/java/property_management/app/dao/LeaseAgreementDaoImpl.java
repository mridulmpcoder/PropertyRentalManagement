package property_management.app.dao;

import property_management.app.dao.LeaseAgreementDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import property_management.app.entities.LeaseAgreement;

import java.util.Collections;
import java.util.List;

@Repository
public class LeaseAgreementDaoImpl implements LeaseAgreementDao {

    private final JdbcTemplate jdbcTemplate;

    public LeaseAgreementDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LeaseAgreement> getAllLeaseAgreements() {
        try {
            String sql = "SELECT * FROM lease_agreements";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LeaseAgreement.class));
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
            return Collections.emptyList(); // Return an empty list on error
        }
    }


    @Override
    public LeaseAgreement getLeaseAgreementById(int leaseId) {
        String sql = "SELECT * FROM lease_agreements WHERE lease_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{leaseId}, new BeanPropertyRowMapper<>(LeaseAgreement.class));
    }
    
    // New method to get all lease agreements by user_id (tenant_id)
    @Override
    public List<LeaseAgreement> getLeaseAgreementsByUserId(int userId) {
        try {
            // First, get tenant_id using user_id
            String tenantSql = "SELECT tenant_id FROM tenants WHERE user_id = ?";
            Integer tenantId = jdbcTemplate.queryForObject(tenantSql, new Object[]{userId}, Integer.class);
            
            if (tenantId == null) {
                return Collections.emptyList(); // No tenant found for the user_id
            }

            // Now, get lease agreements using tenant_id
            String leaseSql = "SELECT * FROM lease_agreements WHERE tenant_id = ?";
            return jdbcTemplate.query(leaseSql, new Object[]{tenantId}, new BeanPropertyRowMapper<>(LeaseAgreement.class));
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
            return Collections.emptyList(); // Return an empty list on error
        }
    }
    
}
