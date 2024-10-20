package property_management.app.controller;
 
import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import property_management.app.entities.User;
import property_management.app.dao.PaymentDao;
import property_management.app.dao.PropertyDao;

import property_management.app.dao.TenantDao;

import property_management.app.entities.Payment;
import property_management.app.entities.Property;
import property_management.app.entities.Tenant;
 
@Controller
@RequestMapping("/tenant")
public class TenantController {

	private final PropertyDao propertyDao;
 
	private final TenantDao tenantDao;
 
	@Autowired
	public TenantController(TenantDao tenantDao, PropertyDao propertyDao) {
		this.propertyDao = propertyDao;
		this.tenantDao = tenantDao;
	}

 
	private PaymentDao paymentDao;
 
	@GetMapping("/tenantDashboard")
	public String tenantDashboard(@ModelAttribute("user") User user, Model model, HttpSession session,
	        HttpServletRequest request) {
	    User loggedInUser = (User) session.getAttribute("user");
	    if (loggedInUser != null) {
	        model.addAttribute("loggedInUser", loggedInUser);
	        
	        // Log the User ID
	        System.out.println("Logged in User ID: " + loggedInUser.getUserId());
	        
	        // Fetch property ID for the logged-in user
	        Integer propertyId = propertyDao.findPropertyIdByUserId(loggedInUser.getUserId());
	        System.out.println("Fetched Property ID: " + propertyId);

	        // Fetch tenant data
	        Tenant tenant = tenantDao.getTenantByUserId(loggedInUser.getUserId());
	        if (tenant != null) {
	            String status = tenant.getTenantStatus();
	            model.addAttribute("status", status);
	            model.addAttribute("propertyId", propertyId);

	            // Log tenant status
	            System.out.println("Fetched Tenant Status: " + status);
	            request.setAttribute("status", status);
	        } else {
	            System.out.println("No tenant data found for User ID: " + loggedInUser.getUserId());
	            model.addAttribute("status", "No tenant data found.");
	            // Optionally handle this case (e.g., redirect or show a message)
	        }
	    } else {
	        System.out.println("User is not logged in.");
	    }
	    return "tenant_dashboard"; // Your JSP page
	}

	
//	@GetMapping("/pendingPropertyDetails/{propertyId}")
//    public String getPendingPropertyDetails(@PathVariable Integer propertyId, Model model, HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//        if (loggedInUser != null) {
//            // Fetch property details
//            Property property = propertyDao.findPropertyById(propertyId);
//            model.addAttribute("property", property);
//
//            // Fetch tenant details based on user ID and property ID
//            Tenant tenant = tenantDao.getTenantByUserIdAndPropertyId(loggedInUser.getUserId(), propertyId);
//            if (tenant != null) {
//                model.addAttribute("tenant", tenant);
//                model.addAttribute("status", tenant.getTenantStatus());
//                System.out.println("Fetched Tenant Status: " + tenant.getTenantStatus());
//            } else {
//                System.out.println("No tenant request found for User ID: " + loggedInUser.getUserId() + " and Property ID: " + propertyId);
//            }
//        }

//        return "pending_property_details"; // Your JSP page
//    }
//
//    @DeleteMapping("/deleteTenantRequest/{tenantId}")
//    public String deleteTenantRequest(@PathVariable Integer tenantId, RedirectAttributes redirectAttributes) {
//        // Delete the tenant request from the database
//        tenantDao.deleteTenantById(tenantId);
//
//        redirectAttributes.addFlashAttribute("successMessage", "Tenant request deleted successfully.");
//        return "redirect:/property/PropertyPage"; // Redirect to a relevant page after deletion
//    }


	@GetMapping("/myPropertyDetails/{propertyId}")
	public String showPropertyDetails(@PathVariable int propertyId, Model model, HttpSession session) {
		Optional<Property> optionalProperty = propertyDao.findPropertyById(propertyId);
		if (optionalProperty.isPresent()) {
			model.addAttribute("property", optionalProperty.get());

			// Get logged-in user from session
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			model.addAttribute("loggedInUser", loggedInUser);

			return "property_details"; // Assuming 'property_details.jsp'
		} else {
			model.addAttribute("errorMessage", "Property not found.");
			return "error_page"; // Handle error case
		}

	}
	
	@GetMapping("/addTenantDetails")
	public String addTenantDetails(@RequestParam("propertyId") int propertyId, Model model) {
	    // Add logic to collect or initialize tenant details here
	    Property property = propertyDao.findPropertyById(propertyId).orElse(null);
	    
	    if (property != null) {
	        model.addAttribute("property", property);
	    }

	    // Redirect to a tenant details page (e.g., tenant_details.jsp)
	    return "tenant_details";
	}
	@PostMapping("/save")
	public String saveTenant(@RequestParam String tenantType,
	                         @RequestParam int noOfPersons,
	                         @RequestParam String tenantStatus,
	                         @RequestParam int propertyId,
	                         @RequestParam int userId,
	                         HttpSession session,
	                         RedirectAttributes redirectAttributes,Model model) {
	    Tenant tenant = new Tenant();
	    tenant.setTenantType(tenantType);
	    tenant.setNoOfPerson(noOfPersons);
	    tenant.setTenantStatus(tenantStatus);
	    tenant.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	    tenant.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
	    tenant.setPropertyId(propertyId);
	    tenant.setUserId(userId);

	    tenantDao.saveTenant(tenant);
	    
	    model.addAttribute("tenantType", tenant.getTenantType());
	    model.addAttribute("noOfPersons", tenant.getNoOfPerson());
	    model.addAttribute("propertyId", tenant.getPropertyId());
	    model.addAttribute("tenantId", tenant.getTenantId());

	    

	    // Set a success message and session attribute
	    redirectAttributes.addFlashAttribute("successMessage", "Tenant registration successful!");
	    session.setAttribute("formSubmitted", true); // Set session attribute

	    return "tenant_success"; // Redirect to success page
	}


 

	@GetMapping("/lastPayment")
	public String lastPayment(@RequestParam("tenantId") Long tenantId, HttpSession session, Model model) {
		System.out.println("payment controller");
		// Assuming tenantId is stored in the session after login
		List<Payment> payments = paymentDao.fetchPaymentsByTenantId(tenantId);
		model.addAttribute("paymentList", payments);
		return "payment_page"; // The JSP page to display the payment details
	}

	@GetMapping("/paymentPage")
	public String paymentPage() {
		return "payment";
	}

	@GetMapping("/submitPayment")
	public String submitPayment() {

		return "success";
	}

	@GetMapping("/maintenanceRequest")
	public String maintenanceRequest() {
		return "maintenance_request";
	}
 
	@GetMapping("/submitPayment")
	public String submitPayment() {
 
		return "success";
	}
 
	@GetMapping("/maintenanceRequest")
	public String maintenanceRequest() {
		return "maintenance_request";
	}
 
	@GetMapping("/viewTenants")
	public String getAllTenants(Model model) {
		List<Tenant> tenantList = tenantDao.getAllTenants();
		model.addAttribute("tenantList", tenantList);
		return "view_tenants"; // Refers to view_tenants.jsp
	}
 
	@PostMapping("/assignTenant")
	public String assignTenantToProperty(@RequestParam int tenantId, @RequestParam int propertyId) {
		tenantDao.assignTenantToProperty(tenantId, propertyId);
		return "redirect:/viewTenants";
	}
 
	@PostMapping("/removeTenant")
	public String removeTenantFromProperty(@RequestParam int tenantId, @RequestParam int propertyId) {
		tenantDao.removeTenantFromProperty(tenantId, propertyId);
		return "redirect:/viewTenants";
	}
}