package property_management.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import property_management.app.entities.User;

public interface UserDao {

	int insertUser(User user) throws IOException, SerialException, SQLException;

	Map<String, Object> fetchPwds(String username);

	User fetchUser(String username);

	User modifyUser(User updatedUser) throws SerialException, IOException, SQLException;

	User getUserById(int userId);
}
