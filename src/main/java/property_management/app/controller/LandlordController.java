package property_management.app.controller;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import property_management.app.dao.TenantDaoImpl;
import property_management.app.dao.UserDaoImpl;

import property_management.app.entities.User;
import property_management.app.model.Tenant;
 
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
 
	@GetMapping("/addProperty")

	public String addProperty() {
 
		return "addProperty";

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
 
	@GetMapping("/maintenanceRequest")

	public String maintenanceRequest() {

		return "maintenance_request";

	}
 
	@GetMapping("/paymentPage")

	public String paymentPage() {

		return "payment_page";

	}
 
	@GetMapping("/managerAssingment")

	public String managerAssingment() {

		return "manager_assignment";

	}
	
	@GetMapping("/tenantManagement")

	public String tenantManagement() {

		return "tenant_management";

	}
	@GetMapping("/manageTenants")

	public String manageTenants() {

		return "manage_tenants"; // JSP file name without extension

	}
	
	@GetMapping("/viewTenants")

	public String viewTenants() {

		return "view_tenants"; // JSP file name without extension

	}
 
	/*@GetMapping("/addTenants")

	public String addTenants() {

		return "add_tenant"; // JSP file name without extension

	}*/
 
	@GetMapping("/deleteTenants")

	public String deleteTenants() {

		return "delete_tenant"; // JSP file name without extension

	}
	@GetMapping("/managerMaintenance")

	public String managerMaintenance() {

		return "manager_maintenance"; // JSP file name without extension

	}
	
	@GetMapping("/assignTechnician")

	public String assignTechnician() {

		return "assign_technician"; // JSP file name without extension

	}
 
	@GetMapping("/addTechnician")

	public String addTechnician() {

		return "add_technician"; // JSP file name without extension

	}
	
	 /*@GetMapping("/openAddTenant")
	    public String openAddTenant() {
	        return "add_tenant"; // JSP file name without extension
	    }*/
	 
	 @GetMapping("/addTenants")

		public String addTenants() {

			return "add_tenant"; // JSP file name without extension

		}
	    // New PostMapping to insert tenant into the database
	@PostMapping("/addTenant")
	    public String addTenant(
	    		@RequestParam("firstName")String firstName,
	    		@RequestParam("lastName")String lastName,
	    		@RequestParam("email") String email, 
	    		@RequestParam("Contact") String Contact) {
		
		    Tenant tenant = new Tenant();
		    tenant.setFirstName(firstName);
		    tenant.setLastName(lastName);
	        tenant.setEmail(email);
	        tenant.setContact(Contact);
			/*
			 * User newUser = new User(); newUser.setFirstName(firstName);
			 * newUser.setLastName(lastName); newUser.setEmailId(email);
			 * newUser.setContact(mobileNo);
			 */
	        
	        
	        TenantDaoImpl.save(tenant);
	        return "redirect:/landlord/viewTenants"; // Redirect to view tenants after adding
	    }
 
	// Additional mappings for other pages...

}

 