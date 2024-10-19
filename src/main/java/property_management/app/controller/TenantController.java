package property_management.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import property_management.app.entities.User;
import property_management.app.dao.PaymentDao;
import property_management.app.dao.PropertyDao;
import property_management.app.entities.Payment;
import property_management.app.entities.Property;

@Controller
@RequestMapping("/tenant")
public class TenantController {

	private final PropertyDao propertyDao;

	@Autowired
	public TenantController(PropertyDao propertyDao) {
		this.propertyDao = propertyDao;
	}

	private PaymentDao paymentDao;

	@GetMapping("/tenantDashboard")
	public String tenantDashboard(@ModelAttribute("user") User user, Model model, HttpSession session,
			HttpServletRequest request) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser != null) {
			model.addAttribute("loggedInUser", loggedInUser);

			// Fetch property ID for the logged-in user
			Integer propertyId = propertyDao.findPropertyIdByUserId(loggedInUser.getUserId());
			model.addAttribute("propertyId", propertyId);

			// Set propertyId as a request attribute
			System.out.println("Fetched Property ID: " + propertyId);
			request.setAttribute("propertyId", propertyId);
		}
		return "tenant_dashboard"; // Your JSP page
	}

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

//	@GetMapping("/lastPayment")
//	public String lastPayment() {
//		return "payment_page";
//	}

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

}
