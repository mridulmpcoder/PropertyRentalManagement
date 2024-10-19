package property_management.app.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import property_management.app.entities.Manager;

import java.util.List;

@Repository
public class ManagerDaoImpl implements ManagerDao {
    private final JdbcTemplate jdbcTemplate;
    
    
	public ManagerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Manager> getAllManagers() {
        String sql = "SELECT * FROM managers";
       return jdbcTemplate.query(sql,new ManagerRowMapper());
    }

    @Override
    public void approveManager(int managerId) {
        String sql = "UPDATE managers SET approved = TRUE WHERE manager_id = ?";
        jdbcTemplate.update(sql, managerId);
    }

    @Override
    public void rejectManager(int managerId) {
        String sql = "UPDATE managers SET approved = FALSE WHERE manager_id = ?";
        jdbcTemplate.update(sql, managerId);
    }

    @Override
    public List<Manager> getApprovedManagers() {
        String sql = "SELECT * FROM managers WHERE approved = TRUE";
        return jdbcTemplate.query(sql, new ManagerRowMapper());
    }
    


	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		
	}

	
}
