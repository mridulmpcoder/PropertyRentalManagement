package property_management.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@GetMapping("/managerDashboard")
	public String managerdashboard() {
		return "manager_dashboard"; // JSP file name without extension
	}
	
	@GetMapping("/tenantManagement")
	public String tenantManagement() {
		return "tenant_management"; // JSP file name without extension
	}
	
	@GetMapping("/managerMaintenance")
	public String managerMaintenance() {
		return "manager_maintenance"; // JSP file name without extension
	}

}
