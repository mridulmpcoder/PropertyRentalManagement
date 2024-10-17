package property_management.app.controller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import property_management.app.dao.PropertyDaoImpl;

import property_management.app.entities.Property;

import property_management.app.entities.User;

@Controller

@RequestMapping("/property")

public class PropertyController {

	private final PropertyDaoImpl propertyDaoImpl;

	@Autowired

	public PropertyController(PropertyDaoImpl propertyDaoImpl) {

		this.propertyDaoImpl = propertyDaoImpl;

	}

	@GetMapping("/PropertyPage")

	public String showPropertiesPage(@RequestParam(value = "search", required = false) String search,

			@RequestParam(value = "location", required = false) String location,

			@RequestParam(value = "facilities", required = false) List<String> facilities,

			Model model, HttpSession session) {

		// Fetch properties based on search and filter criteria

		List<Property> properties = propertyDaoImpl.findProperties(search, location, facilities);

		// Fetch unique locations for the dropdown

		List<String> locations = propertyDaoImpl.findUniqueLocations();

		// Hardcode facilities for the checkbox

		List<String> availableFacilities = List.of("Parking", "Swimming Pool", "Gym", "Security System", "Internet",

				"Furnished", "Air Conditioning", "Elevator", "Garden");

		// Add properties and filters to the model

		model.addAttribute("properties", properties);

		model.addAttribute("locations", locations);

		model.addAttribute("facilities", availableFacilities);

		// Get logged-in user from session

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		model.addAttribute("loggedInUser", loggedInUser);

		return "property_page"; // property_page.jsp

	}

	@GetMapping("/PropertyDetails/{propertyId}")

	public String showPropertyDetails(@PathVariable int propertyId, Model model, HttpSession session) {

		Optional<Property> optionalProperty = propertyDaoImpl.findPropertyById(propertyId);

		if (optionalProperty.isPresent()) {

			model.addAttribute("property", optionalProperty.get());

			// Get logged-in user from session

			User loggedInUser = (User) session.getAttribute("loggedInUser");

			model.addAttribute("loggedInUser", loggedInUser);

			return "property_details"; // Assuming 'property_details.jsp'

		}

		return "redirect:/property/PropertyPage"; // Redirect if property not found

	}

	@GetMapping("/TenantHomePage")

	public String openTenantHomePage(Model model, HttpSession session) {

		List<Property> latestProperties = propertyDaoImpl.getLatestProperties();

		model.addAttribute("latestProperties", latestProperties);

		// Get logged-in user from session

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		model.addAttribute("loggedInUser", loggedInUser);

		return "home";

	}

	@GetMapping("/openAddProperty")

	public String openAddProperty(Model model, HttpSession session) {

		// Get logged-in user from session

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		model.addAttribute("loggedInUser", loggedInUser);

		return "addProperty";

	}

	@PostMapping("/addProperty")

	public String addProperty(@ModelAttribute Property property,

			@RequestParam("propertyImage") MultipartFile propertyImage,

			RedirectAttributes attributes, HttpSession session) throws IOException, SQLException {

		if (propertyImage != null && !propertyImage.isEmpty()) {

			// Convert MultipartFile to byte[]

			byte[] imageBytes = propertyImage.getBytes();

			property.setpropertyImage(imageBytes); // Set image bytes in the property object

		}

		int result = propertyDaoImpl.insertUser(property);

		if (result > 0) {

			attributes.addFlashAttribute("message", "Addition Successful");

			// Get logged-in user from session

			User loggedInUser = (User) session.getAttribute("loggedInUser");

			if (loggedInUser != null && loggedInUser.getRole().equals("landlord")) {

				return "redirect:/landlord/openPropertyManagement"; // Redirect based on the user's role

			}

			return "redirect:/property/PropertyPage";

		} else {

			attributes.addFlashAttribute("message", "Addition Failed");

			return "redirect:/property/openAddProperty";

		}

	}

}
