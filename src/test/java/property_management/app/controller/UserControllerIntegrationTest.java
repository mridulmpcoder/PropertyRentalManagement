package property_management.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import property_management.app.dao.UserDao;
import property_management.app.entities.User;

@SpringBootTest
@Transactional
public class UserControllerIntegrationTest {
	
	 @Autowired
	    private UserController userController;

	    @Autowired
	    private UserDao userDao;

	    private RedirectAttributes redirectAttributes;

	    @BeforeEach
	    public void setUp() {
	        // Initialize RedirectAttributes (you can use a real implementation or just an empty class)
	        redirectAttributes = new RedirectAttributes() {

				@Override
				public Model addAllAttributes(Map<String, ?> attributes) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean containsAttribute(String attributeName) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Object getAttribute(String attributeName) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Map<String, Object> asMap() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes addAttribute(String attributeName, Object attributeValue) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes addAttribute(Object attributeValue) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes addAllAttributes(Collection<?> attributeValues) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes mergeAttributes(Map<String, ?> attributes) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes addFlashAttribute(String attributeName, Object attributeValue) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RedirectAttributes addFlashAttribute(Object attributeValue) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Map<String, ?> getFlashAttributes() {
					// TODO Auto-generated method stub
					return null;
				}
	            // Implement necessary methods or leave empty for basic testing
	        };
	    }

	    @AfterEach
	    public void tearDown() {
	        // Clean up logic if necessary (database cleanup, etc.)
	    }

	    @Test
	    public void testManagerRegister_Success() throws IOException, SQLException {
	        // Arrange: Create a real User instance
	        User user = new User();
	        user.setFirstName("John");
	        user.setLastName("Doe");
	        user.setEmailId("john@example.com");
	        user.setMobileNo("1234567890");
	        user.setDateOfBirth(new Date(System.currentTimeMillis()));
	        user.setUsername("johndoe");
	        user.setPassword("password123");

	        MultipartFile profileImage = null;  // You can set this to a real image if needed
	        user.setProfileImage(profileImage);

	        // Act: Call the managerRegister method
	        String result = userController.managerRegister(user, redirectAttributes);

	        // Assert: Verify that the registration was successful
	        assertEquals("redirect:/user/openLoginPage", result);
	        assertNotNull(user.getPasswordSalt());
	        assertNotNull(user.getPasswordHash());

	        // Assert that the user was inserted into the database
	        User insertedUser = userDao.fetchUser("johndoe");  // Assuming findUserByUsername is available in UserDao
	        assertNotNull(insertedUser);
	        assertEquals("John", insertedUser.getFirstName());
	        assertEquals("Doe", insertedUser.getLastName());
	        assertEquals(2, insertedUser.getRole().getRoleId());  // Role ID for manager
	        assertEquals("P", insertedUser.getStatus());  // Status should be 'P' (Pending)
	    }

	    @Test
	    public void testManagerRegister_Failure() throws IOException, SQLException {
	        // Arrange: Create an invalid user (e.g., missing email)
	        User user = new User();
	        user.setFirstName("John");
	        user.setLastName("Doe");
	        user.setEmailId(null);  // Invalid email
	        user.setMobileNo("1234567890");
	        user.setDateOfBirth(new Date(System.currentTimeMillis()));
	        user.setUsername("johndoe");
	        user.setPassword("password123");

	        MultipartFile profileImage = null;  // You can set this to a real image if needed
	        user.setProfileImage(profileImage);

	        // Act: Call the managerRegister method
	        String result = userController.managerRegister(user, redirectAttributes);

	        // Assert: Verify that the registration failed and redirected back to registration page
	        assertEquals("redirect:/user/openRegistrationPage", result);

	        // Check that the user was NOT inserted into the database
	        User insertedUser = userDao.fetchUser("johndoe");
	        assertNull(insertedUser);  // User should not exist due to invalid registration
	    }

}
