package property_management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import property_management.app.dao.UserDaoImpl;
import property_management.app.entities.User;

@Controller
@RequestMapping("/landlord")
public class LandlordController {

	private User user;

	@Autowired
	UserDaoImpl userDaoImpl;

	@GetMapping("/openLandlordDashboard")
	public String showDashboard() {
		return "landlord_dashboard"; // JSP file name without extension
	}

	@GetMapping("/openPropertyManagement")
	public String openPropertyManagement() {

		return "property_management";
	}

	@GetMapping("/openReports")
	public String openReports() {
		return "view_reports"; // JSP file name without extension
	}

	// Additional mappings for other pages...
}
