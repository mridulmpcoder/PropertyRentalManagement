package property_management.app.controller;

import java.io.IOException;
import java.sql.SQLException;

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
import property_management.app.entities.User;
import property_management.utility.Password;

@Controller
@RequestMapping("/user")
public class LandlordController {

	private User user;

	@Autowired
	UserDaoImpl userDaoImpl;

	@GetMapping("/openPropertyManagement")
	public String openPropertyManagement() {
		return "property_management";
	}

	@GetMapping("/openLoginPage")
	public String openLoginPage() {
		return "user_login";
	}

	@GetMapping("/openRegistrationPage")
	public ModelAndView openRegistrationPage(ModelAndView modelAndView) {

		System.out.println("\n openUserRegistrationPage is called");

		modelAndView.setViewName("user_registration");

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

				return "landlord_dashboard";

			} else {
				attributes.addFlashAttribute("message", "Incorrect Password");
			}
		} catch (EmptyResultDataAccessException e) {
			attributes.addFlashAttribute("message", "Incorrect Username");
		}

		return "redirect:/user/openLoginPage";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, RedirectAttributes attributes)
			throws IOException, SerialException, SQLException {

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

	@GetMapping("/openLandlordDashboard")
	public String showDashboard() {
		return "landlord_dashboard"; // JSP file name without extension
	}

	@GetMapping("/openReports")
	public String openReports() {
		return "view_reports"; // JSP file name without extension
	}

	@GetMapping("/logout")
	public String logout() {
		return "index"; // JSP file name without extension
	}

	// Additional mappings for other pages...
}
