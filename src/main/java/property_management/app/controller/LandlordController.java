package property_management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import property_management.app.dao.ManagerDao;
import property_management.app.dao.UserDaoImpl;
import property_management.app.entities.Manager;
import property_management.app.entities.User;

@Controller

@RequestMapping("/landlord")

public class LandlordController {

	private User user;
	

    @Autowired
    private ManagerDao managerDao;


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

	@GetMapping("/manageManagers")
	public String manageManagers(Model model) {
		List<Manager> managers = managerDao.getAllManagers();
		model.addAttribute("managers", managers);
		return "manage_managers"; // JSP page name
	}



	@GetMapping("/approveRejectManagers")

	public String approveRejectManagers() {

		return "approveRejectManagers";

	}

	@GetMapping("/assignManagers")

	public String assignManagers() {

		return "assign_managers";

	}

	@GetMapping("/tenantManagement")

	public String tenantManagement() {

		return "tenant_management";

	}

	@GetMapping("/viewTenants")

	public String viewTenants() {

		return "view_tenants"; // JSP file name without extension

	}

	@GetMapping("/manageTenants")

	public String manageTenants() {

		return "manage_tenants"; // JSP file name without extension

	}

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

	@GetMapping("/addTenants")

	public String addTenants() {

		return "add_tenant"; // JSP file name without extension

	}

	// Additional mappings for other pages...

}
