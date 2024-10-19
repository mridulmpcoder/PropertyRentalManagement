package property_management.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import property_management.app.dao.PropertyDao;
import property_management.app.dao.UserDao;
import property_management.app.entities.Role;
import property_management.app.entities.User;
import property_management.utility.Password;

@Controller
@RequestMapping("/user")
public class UserController {

	private User user;

	@Autowired
	UserDao userDao;
	

	@GetMapping("/openLoginPage")
	public String openLoginPage() {
		return "user_login";
	}

	@GetMapping("/openManagerRegistrationPage")
	public String openManagerRegistrationPage() {

		return "manager_registration";
	}

	@GetMapping("/openTenantRegistrationPage")
	public String openTenantRegistrationPage() {

		return "tenant_registration";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model,
			RedirectAttributes attributes) {

		System.out.println("\n login request data: " + username + ", " + password);

		try {
			user = userDao.fetchUser(username);
			System.out.println(user);

			String pwdSalt = user.getPasswordSalt();
			String oldPwdHash = user.getPasswordHash();

			String newPassword = password + pwdSalt;
			String newPasswordHash = Password.generatePwdHash(newPassword);

			if (newPasswordHash.equals(oldPwdHash)) {
				session.setAttribute("user", user);
				session.setAttribute("loggedInUser", user);

				session.setAttribute("isLoggedIn", true);
				
				// Set session timeout to 30 minutes (1800 seconds)
	            session.setMaxInactiveInterval(30 * 120);

				
				model.addAttribute("user", user);

				int roleId = user.getRole().getRoleId();
				if (roleId == 1) {
					return "landlord_dashboard";
				} else if (roleId == 2) {
					return "manager_dashboard";
				} else if (roleId == 3) {
					
	                return "redirect:/user/tenantDashboard"; // Use redirect to the tenant controller
				}
			} else {
				attributes.addFlashAttribute("message", "Incorrect Password");
			}
		} catch (EmptyResultDataAccessException e) {
			attributes.addFlashAttribute("message", "Incorrect Username");
		}

		return "redirect:/user/openLoginPage";
	}

	@PostMapping("/tenantRegister")
	public String tenantRegister(@ModelAttribute User user, RedirectAttributes attributes)
			throws IOException, SerialException, SQLException {
		user.setRole(new Role(3));
		user.setStatus("A");

		System.out.println("\n user : " + user);

		// Password Encryption starts
		String passwordSalt = Password.generatePwdSalt(10);
		user.setPasswordSalt(passwordSalt);

		// temporary data => password+salt
		String newPassword = user.getPassword() + passwordSalt; // 1234rdvyjtftyf

		String passwordHash = Password.generatePwdHash(newPassword);
		user.setPasswordHash(passwordHash);
		// Password Encryption completes

		int result = userDao.insertUser(user);

		if (result > 0) {
			attributes.addFlashAttribute("message", "Registration Successful");
			return "redirect:/user/openLoginPage";
		} else {
			attributes.addFlashAttribute("message", "Registration Failed");
			return "redirect:/user/openRegistrationPage";
		}
	}

	@PostMapping("/managerRegister")
	public String managerRegister(@ModelAttribute User user, RedirectAttributes attributes)
			throws IOException, SerialException, SQLException {
		user.setRole(new Role(2));
		user.setStatus("P");

		System.out.println("\n user : " + user);

		// Password Encryption starts
		String passwordSalt = Password.generatePwdSalt(10);
		user.setPasswordSalt(passwordSalt);

		// temporary data => password+salt
		String newPassword = user.getPassword() + passwordSalt; // 1234rdvyjtftyf

		String passwordHash = Password.generatePwdHash(newPassword);
		user.setPasswordHash(passwordHash);
		// Password Encryption completes

		int result = userDao.insertUser(user);

		if (result > 0) {
			attributes.addFlashAttribute("message", "Registration Successful");
			return "redirect:/user/openLoginPage";
		} else {
			attributes.addFlashAttribute("message", "Registration Failed");
			return "redirect:/user/openRegistrationPage";
		}

	}

	@GetMapping("/viewProfile")
	public String viewProfile(HttpSession session, Model model) throws IOException, SQLException {

		User sessionUser = (User) session.getAttribute("user"); // Retrieve user from session
		System.err.println(sessionUser);

		if (sessionUser == null) {
			model.addAttribute("errorMessage", "No user found in session.");
			return "error"; // Redirect to error page if no user in session
		}
		System.out.println("User Status: " + sessionUser.getStatus());

		// Convert profile image to Base64 if exists
		if (sessionUser.getProfileImage() != null && !sessionUser.getProfileImage().isEmpty()) {
			byte[] imageBytes = sessionUser.getProfileImage().getBytes();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			session.setAttribute("profileImage", base64Image);
			model.addAttribute("profileImage", base64Image);
		} else {
			model.addAttribute("profileImage", null);
		}

		if (sessionUser.getIdProof() != null && !sessionUser.getIdProof().isEmpty()) {

			byte[] imageBytes = sessionUser.getIdProof().getBytes();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			session.setAttribute("idProof", base64Image);
			model.addAttribute("idProof", base64Image);
		} else {
			model.addAttribute("idProof", null);
		}

		model.addAttribute("user", sessionUser); // Pass user data to the view
		return "profile"; // The JSP page to display the profile
	}

	// Show the update profile page with pre-filled data
	@GetMapping("/update")
	public String showUpdateProfilePage(HttpSession session, Model model) throws IOException {
		User sessionUser = (User) session.getAttribute("user"); // Retrieve user from session
		if (sessionUser == null) {
			model.addAttribute("errorMessage", "No user found in session.");
			return "error"; // Redirect to error page if no user in session
		}
		byte[] imageBytes = sessionUser.getProfileImage().getBytes();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		model.addAttribute("profileImage", base64Image);
		
		byte[] idImageBytes = sessionUser.getIdProof().getBytes();
		String idBase64Image = Base64.getEncoder().encodeToString(idImageBytes);
		model.addAttribute("idProof", idBase64Image);

		model.addAttribute("user", sessionUser); // Add the session user object to pre-fill the form
		return "updateProfile"; // JSP page to be displayed for updating profile
	}

	// Handle the update form submission
	@PostMapping("/update")
	public String updateUserProfile(@ModelAttribute("user") User user,
			@RequestParam("profileImage") MultipartFile profileImage,@RequestParam("idProof") MultipartFile idProof, HttpSession session,
			RedirectAttributes redirectAttributes) throws SerialException, IOException, SQLException {

		System.out.println("start" + profileImage);
		// Retrieve user from session
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser == null) {
			redirectAttributes.addFlashAttribute("errorMessage", "No user found in session.");
			return "redirect:/user/viewProfile"; // Redirect to profile page if no user in session
		}

		// Update session user details
		sessionUser.setFirstName(user.getFirstName());
		sessionUser.setLastName(user.getLastName());
		sessionUser.setEmailId(user.getEmailId());
		sessionUser.setMobileNo(user.getMobileNo());
		sessionUser.setUsername(user.getUsername());
		sessionUser.setDateOfBirth(user.getDateOfBirth());
		sessionUser.setUsername(user.getUsername());
		sessionUser.setStatus(user.getStatus());

		// If a new profile image is uploaded, set it to the session user
		if (profileImage != null && !profileImage.isEmpty()) {
			sessionUser.setProfileImage(profileImage);
			byte[] imageBytes = profileImage.getBytes();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			session.setAttribute("profileImage", base64Image);
		}
		
		if (idProof != null && !idProof.isEmpty()) {
			sessionUser.setIdProof(idProof);
			byte[] imageBytes = idProof.getBytes();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			session.setAttribute("idProof", base64Image);
		}

		// Update the user in the database
		boolean isUpdated = userDao.updateUser(sessionUser);
		if (isUpdated) {
			// Update session with the new user details
			session.setAttribute("user", sessionUser); // Update session user after successful DB update
			redirectAttributes.addFlashAttribute("successMessage", "Profile updated successfully!");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to update profile.");
		}

		return "redirect:/user/viewProfile"; // Redirect to view profile after update
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user_login"; // JSP file name without extension
	}
	
	private final PropertyDao propertyDao;

	@Autowired
	public UserController(PropertyDao propertyDao) {
		this.propertyDao = propertyDao;
	}
	
	@GetMapping("/tenantDashboard")
	public String tenantDashboard(@ModelAttribute("user") User user,Model model, HttpSession session, HttpServletRequest request) {
	    User loggedInUser = (User) session.getAttribute("user");
	    if (loggedInUser != null) {
	        model.addAttribute("loggedInUser", loggedInUser);

	        // Fetch property ID for the logged-in user
	        Integer propertyId = propertyDao.findPropertyIdByUserId(loggedInUser.getUserId());
		    model.addAttribute("propertyId", propertyId);

	        // Set propertyId as a request attribute
	        System.out.println("Fetched Property ID: " + propertyId);
	        request.setAttribute("propertyId", propertyId);
	    }
	    return "tenant_dashboard"; // Your JSP page
	}
	

}
