package property_management.app.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import property_management.app.entities.Role;
import property_management.app.entities.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertUser(User user) {
		String sql = "INSERT INTO user (first_name, last_name, email_id, mobile_no, date_of_birth, username, passwordSalt, passwordHash, status, role_id, profile_image, id_proof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Convert MultipartFile to byte array
		byte[] profileImageBytes = null;
		if (user.getProfileImage() != null && !user.getProfileImage().isEmpty()) {
			try {
				profileImageBytes = user.getProfileImage().getBytes();
			} catch (IOException e) {
				e.printStackTrace(); // Handle exception appropriately in production
			}
		}
		
		byte[] idProofBytes = null;
		if (user.getIdProof() != null && !user.getIdProof().isEmpty()) {
			try {
				idProofBytes = user.getIdProof().getBytes();
			} catch (IOException e) {
				e.printStackTrace(); // Handle exception appropriately in production
			}
		}

		return jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmailId(), user.getMobileNo(),
				user.getDateOfBirth(), user.getUsername(), user.getPasswordSalt(), user.getPasswordHash(),
				user.getStatus(), user.getRole().getRoleId(), profileImageBytes, idProofBytes);
	}

	@Override
	public List<Role> fetchAllRoles() {
		String sql = "SELECT * FROM roles WHERE role_id > 1 ORDER BY role_id";
		return jdbcTemplate.query(sql, new RolesRowMapper());
	}

	@Override
	public Map<String, Object> fetchPwds(String username) {
		String sql = "SELECT passwordSalt, passwordHash, role_id, status FROM user WHERE username = ?";
		return jdbcTemplate.queryForMap(sql, username);
	}

	@Override
	public User fetchUser(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);

	}

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM user WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
	}
	
	@Override
	public boolean updateUser(User user) {
	    String sql = "UPDATE user SET first_name = ?, last_name = ?, email_id = ?, mobile_no = ?, date_of_birth = ?, username = ?, status = ?, profile_image = ?, id_proof = ? WHERE user_id = ?";
	    try {
	        int result = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmailId(),
	                user.getMobileNo(), user.getDateOfBirth(), user.getUsername(), user.getStatus(), user.getProfileImage().getBytes(), user.getIdProof().getBytes(), user.getUserId());
	        return result > 0;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}



	/*
	 * @Override public User modifyUser(User user) throws SerialException,
	 * IOException, SQLException {
	 * 
	 * String query =
	 * "UPDATE user SET first_name = ?, last_name = ?, email_id = ?, " +
	 * "mobile_no = ?, date_of_birth = ?, profile_image = ? WHERE user_id = ?";
	 * 
	 * jdbcTemplate.update(query, user.getFirstName(), user.getLastName(),
	 * user.getEmailId(), user.getMobileNo(), user.getDateOfBirth(),
	 * user.getProfileImage(), user.getUserId());
	 * 
	 * return getUserById(user.getUserId());
	 * 
	 * }
	 * 
	 * @Override public User getUserById(int userId) { String sql =
	 * "SELECT * FROM user WHERE user_id = ?"; return
	 * jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId); }
	 */

}
