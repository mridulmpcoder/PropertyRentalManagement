package property_management.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tenant")
public class TenantController {
	
	@GetMapping("/tenantDashboard")
	public String tenantDashboard() {
		return "tenant_dashboard";
	}
	@GetMapping("/maintenanceRequest")
	public String maintenanceRequest() {
		return "maintenance_request";
	}
	
	@GetMapping("/paymentPage")
	public String paymentPage() {
		return "payment_page";
	}

}
