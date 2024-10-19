package property_management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import property_management.app.dao.ManagerDao;
import property_management.app.dao.PropertyDao;
import property_management.app.entities.Manager;
import property_management.app.entities.Property;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private PropertyDao propertyDao;
    
    @GetMapping("/approveRejectManagers")
    public String approveRejectManagers(Model model) {
        System.out.println("Entered approveRejectManagers method");
        
        List<Manager> managers = managerDao.getAllManagers(); // Get all managers
        model.addAttribute("managers", managers);
        
        // Print each manager's details
        if (managers != null && !managers.isEmpty()) {
            for (Manager manager : managers) {
                System.out.println("Manager ID: " + manager.getManagerId() +
                                   ", Experience: " + manager.getExperience_years() +
                                   ", Approved: " + manager.isApproved());
            }
        } else {
            System.out.println("No managers found.");
        }
        
        return "approveRejectManagers"; // JSP page name
    }

    @PostMapping("/approveManager")
    public String approveManager(@RequestParam int managerId,RedirectAttributes redirectAttributes) {
        managerDao.approveManager(managerId);
        redirectAttributes.addFlashAttribute("message", "Manager approved successfully!");
        //return approveRejectManagers(model);
        return "redirect:/approveRejectManagers";
    }

	 @PostMapping("/rejectManager")
	 public String rejectManager(@RequestParam int managerId, RedirectAttributes redirectAttributes) {
	     managerDao.rejectManager(managerId);
	     redirectAttributes.addFlashAttribute("message", "Manager rejected successfully!");
	     return "redirect:/approveRejectManagers";
	 }

    
    
    @GetMapping("/assignManagers")
    public String showAssignManagersPage(Model model) {
    	
        List<Manager> approvedManagers = managerDao.getApprovedManagers();
        List<Property> properties = propertyDao.getAllProperties(); 
        
        model.addAttribute("approvedManagers", approvedManagers);
        model.addAttribute("properties", properties);
        return "assign_managers"; // JSP page name
    }
    

    @PostMapping("/assignManager")
    public String assignManager(@RequestParam int managerId,@RequestParam int propertyId, Model model) {
        propertyDao.assignManagerToProperty(managerId, propertyId);
        
        model.addAttribute("message", "Manager assigned successfully!");
        return showAssignManagersPage(model);
    }
    
    
    @PostMapping("/unassignManager")
    public String unassignManager(@RequestParam int propertyId, Model model) {
        propertyDao.unassignManagerFromProperty(propertyId);
        model.addAttribute("message", "Manager unassigned successfully!");
        return showAssignManagersPage(model);
    }

}
