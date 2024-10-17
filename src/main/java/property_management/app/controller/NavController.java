package property_management.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {

	@GetMapping("/")
	public String showHomePage() {
		return "user_login"; // JSP file name without extension
	}

	@GetMapping("/aboutUs")
	public String openAboutPage() {
		return "about_us";
	}

}
