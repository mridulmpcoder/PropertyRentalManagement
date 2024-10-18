package property_management.app.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import property_management.app.dao.MaintenanceRequestDao;
import property_management.app.entities.MaintenanceRequest;

import java.util.Collections;
import java.util.List;

@Controller
public class MaintenanceRequestController {

    private final MaintenanceRequestDao maintenanceRequestDao;

    public MaintenanceRequestController(MaintenanceRequestDao maintenanceRequestDao) {
        this.maintenanceRequestDao = maintenanceRequestDao;
    }

    /*@GetMapping("/api/maintenance-requests")
    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceRequestDao.getAllRequests();
    }*/
    
    @GetMapping("/maintenance-requests")
    public String getAllRequests(Model model) {
        List<MaintenanceRequest> requests = maintenanceRequestDao.getAllRequests();
        model.addAttribute("requests", requests != null ? requests : Collections.emptyList());
        return "manager_maintenance"; // Refers to maintenanceRequests.jsp
    }

}
