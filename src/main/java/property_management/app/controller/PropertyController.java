package property_management.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import property_management.app.dao.PropertyDaoImpl;
import property_management.app.entities.Property;

@Controller
@RequestMapping("/property")
public class PropertyController {

	private final PropertyDaoImpl propertyDaoImpl;

	@Autowired
	public PropertyController(PropertyDaoImpl propertyDaoImpl) {
		this.propertyDaoImpl = propertyDaoImpl;
	}

	@GetMapping("/PropertyPage")
	public String showPropertiesPage(Model model) {
		List<Property> properties = propertyDaoImpl.getAllProperties();
		System.out.println("Fetched Properties in Controller: " + properties); // For console log verification

		// Add properties to the model
		model.addAttribute("properties", properties);

		return "property_page"; // Assuming 'property_page.jsp'
	}

	@GetMapping({ "/TenantHomePage" })
	public String openTenantHomePage(Model model) {

		List<Property> latestProperties = propertyDaoImpl.getLatestProperties();

		model.addAttribute("latestProperties", latestProperties);

		return "home";
	}
	
	
	@GetMapping("/openAddProperty")
	public String openAddProperty() {

		return "addProperty";
	}
	
	@PostMapping("/addProperty")
	public String addProperty(@ModelAttribute Property property, 
	                          @RequestParam("propertyImage") MultipartFile propertyImage, 
	                          RedirectAttributes attributes) throws IOException, SerialException, SQLException {

	    if (propertyImage != null && !propertyImage.isEmpty()) {
	        property.setpropertyImage(propertyImage); // Set image file in the property object
	    }

	    int result = propertyDaoImpl.insertUser(property);

	    if (result > 0) {
	        attributes.addFlashAttribute("message", "Addition Successful");
	        return "redirect:/landlord/openPropertyManagement";
	    } else {
	        attributes.addFlashAttribute("message", "Addition Failed");
	        return "redirect:/property/openAddProperty";
	    }
	}

	
	/*
	 * @PostMapping("/addProperty") public String addProperty(@ModelAttribute
	 * Property property, RedirectAttributes attributes) throws IOException,
	 * SerialException, SQLException {
	 * 
	 * System.out.println("\n user : " + property);
	 * 
	 * int result = propertyDaoImpl.insertUser(property);
	 * 
	 * if (result > 0) { attributes.addFlashAttribute("message",
	 * "Addition Successful"); return "redirect:/landlord/openPropertyManagement"; }
	 * else { attributes.addFlashAttribute("message", "Addition Failed"); return
	 * "redirect:/property/openAddProperty"; } }
	 */

}
