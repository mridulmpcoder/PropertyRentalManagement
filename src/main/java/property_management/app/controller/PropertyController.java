package property_management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import property_management.app.dao.PropertyDaoImpl;
import property_management.app.entities.Property;

@Controller
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

        return "property_page";  // Assuming 'property_page.jsp'
    }

    
    @GetMapping("/aboutUs")
 	public String openAboutPage() {
 		return "about_us";
 	}
    

}
