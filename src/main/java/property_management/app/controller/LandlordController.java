package property_management.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import property_management.app.dao.LandlordDAO;
import property_management.app.dao.UserDaoImpl;
import property_management.app.entities.Landlord;
import property_management.app.entities.User;

@Controller
@RequestMapping("/landlord")
public class LandlordController {
	
	@Autowired 
    private LandlordDAO landlordDAO; 
 
    @GetMapping("/api/payment/details") 
    public Map<String, Object> getPaymentDetails(@RequestParam("tenantId") Long tenantId) { 
        Landlord landlord = landlordDAO.getLandlordDetails(); 
        double amount = 12345.67; // Example amount, you should fetch this based on the tenantId 
 
        Map<String, Object> response = new HashMap<>(); 
        response.put("bankDetails", landlord.getBankDetails()); 
        response.put("upiDetails", landlord.getUpiDetails()); 
        response.put("amount", amount); 
 
        return response; 
    }

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

	@GetMapping("/paymentManagement")
	public String paymentmanagement() {
		return "payment_management"; // JSP file name without extension
	}


	

	@GetMapping("/managerAssingment")
	public String managerAssingment() {
		return "manager_assignment";
	}

	@GetMapping("/manageTenants")
	public String manageTenants() {
		return "manage_tenants"; // JSP file name without extension
	}

	@GetMapping("/addTenants")
	public String addTenants() {
		return "add_tenant"; // JSP file name without extension
	}

	@GetMapping("/deleteTenants")
	public String deleteTenants() {
		return "delete_tenant"; // JSP file name without extension
	}

	@GetMapping("/assignTechnician")
	public String assignTechnician() {
		return "assign_technician"; // JSP file name without extension
	}

	@GetMapping("/addTechnician")
	public String addTechnician() {
		return "add_technician"; // JSP file name without extension
	}

	// Additional mappings for other pages...
}
