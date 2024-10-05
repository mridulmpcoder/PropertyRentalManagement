package property_management.app.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import property_management.app.dao.UserDaoImpl;
import property_management.app.entities.Role;
import property_management.app.entities.User;
import property_management.utility.Password;

@Controller
@RequestMapping("/user")
public class UserController {

	private User user;

	@Autowired
	UserDaoImpl userDaoImpl;

	@GetMapping("/openLoginPage")
	public String openLoginPage() {
		return "user_login";
	}

	@GetMapping("/openManagerRegistrationPage")
	public ModelAndView openManagerRegistrationPage(ModelAndView modelAndView) {

		List<Role> listOfRoles = userDaoImpl.fetchAllRoles();

		modelAndView.addObject("listOfRoles", listOfRoles);
		modelAndView.setViewName("manager_registration");

		return modelAndView;
	}

	@GetMapping("/openTenantRegistrationPage")
	public ModelAndView openTenantRegistrationPage(ModelAndView modelAndView) {

		List<Role> listOfRoles = userDaoImpl.fetchAllRoles();

		modelAndView.addObject("listOfRoles", listOfRoles);
		modelAndView.setViewName("tenant_registration");

		return modelAndView;
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			RedirectAttributes attributes) {

		System.out.println("\n login request data: " + username + ", " + password);

		try {
			user = userDaoImpl.fetchUser(username);
			System.out.println(user);

			String pwdSalt = user.getPasswordSalt();
			String oldPwdHash = user.getPasswordHash();

			String newPassword = password + pwdSalt;
			String newPasswordHash = Password.generatePwdHash(newPassword);

			if (newPasswordHash.equals(oldPwdHash)) {

				model.addAttribute("user", user);

				int roleId = user.getRole().getRoleId();
				if (roleId == 1) {
					return "landlord_dashboard";
				} else if (roleId == 2) {
					return "manager_dashboard";
				} else if (roleId == 3) {
					return "tenant_dashboard";
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

		int result = userDaoImpl.insertUser(user);

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

		int result = userDaoImpl.insertUser(user);

		if (result > 0) {
			attributes.addFlashAttribute("message", "Registration Successful");
			return "redirect:/user/openLoginPage";
		} else {
			attributes.addFlashAttribute("message", "Registration Failed");
			return "redirect:/user/openRegistrationPage";
		}

	}

	@GetMapping("/viewProfile")
	public String viewUserProfile(Model model) throws SQLException, IOException {

		// Assuming profileImage is stored as Blob
		Blob imageBlob = (Blob) user.getProfileImage();

		if (imageBlob != null) {
			byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			model.addAttribute("base64Image", base64Image);
		} else {
			model.addAttribute("base64Image", ""); // Handle when there's no image
		}

		model.addAttribute("user", user);
		return "viewProfile"; // Return view page
	}

//	@GetMapping("/viewProfile")
//	public ModelAndView viewProfile(ModelAndView mView) {
//		mView.setViewName("profile");
//		mView.addObject("user", user);
//		return mView;
//	}

	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User updatedUser, RedirectAttributes attributes)
			throws SerialException, IOException, SQLException {
		// Update user information in the database

		try {
			user = userDaoImpl.modifyUser(updatedUser); // Simulate updating the user object
			attributes.addAttribute("message", "Profile updated successfully");
		} catch (EmptyResultDataAccessException e) {
			attributes.addAttribute("message", "Updation failed. Please try again later");
		}
		return "redirect:/user/viewProfile"; // Redirect back to view profile
	}

	@GetMapping("/logout")
	public String logout() {
		return "index"; // JSP file name without extension
	}

	@GetMapping("/openLandlordDashboard")
	public String showDashboard() {
		return "landlord_dashboard"; // JSP file name without extension
	}

	@GetMapping("/manager_dashboard")
	public String managerdashboard() {
		return "manager_dashboard"; // JSP file name without extension
	}

}
