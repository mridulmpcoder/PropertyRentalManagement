package property_management.app.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
	public int insertUser(User user) throws IOException, SerialException, SQLException {

		Blob profileImage = getBlob(user.getProfileImage());

		String query = "INSERT INTO user " + "(`first_name`, `last_name`, `email_id`, `mobile_no`, "
				+ "`date_of_birth`, `username`, `passwordSalt`, `passwordHash`, "
				+ "`status`, `role_id`, `profile_image`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		return jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmailId(),
				user.getMobileNo(), user.getDateOfBirth(), user.getUsername(), user.getPasswordSalt(),
				user.getPasswordHash(), user.getStatus(), user.getRole().getRoleId(), profileImage);
	}

	private Blob getBlob(MultipartFile image) throws IOException, SerialException, SQLException {
		byte[] byteArr = image.getBytes();
		Blob imageBlob = new SerialBlob(byteArr);
		return imageBlob;
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
	public User modifyUser(User user) throws SerialException, IOException, SQLException {

		Blob profileImage = getBlob(user.getProfileImage());

		String query = "UPDATE user SET first_name = ?, last_name = ?, email_id = ?, "
				+ "mobile_no = ?, date_of_birth = ?, profile_image = ? WHERE user_id = ?";

		jdbcTemplate.update(query, user.getFirstName(), user.getLastName(), user.getEmailId(), user.getMobileNo(),
				user.getDateOfBirth(), profileImage, user.getUserId());
		
		return getUserById(user.getUserId());

	}

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM user WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
	}
}
