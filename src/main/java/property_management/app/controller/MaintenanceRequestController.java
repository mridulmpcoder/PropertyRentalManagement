package property_management.app.controller;



import property_management.app.model.MaintenanceRequest;
import property_management.app.service.MaintenanceRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;

    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    // Method to handle the maintenance request form submission
    @PostMapping("/submit")
    public String submitRequest(
           // @RequestParam("tenantId") int tenantId,
            @RequestParam("requestType") String requestType,
            @RequestParam("description") String description,
            @RequestParam("photo") MultipartFile photo,
            Model model) {

        // Define where to store the uploaded photo
        String photoPath = null;
        if (!photo.isEmpty()) {
            try {
                // Save the uploaded photo to a specific directory
                String uploadDir = "C:/uploads/";
                File uploadFile = new File(uploadDir + photo.getOriginalFilename());
                photo.transferTo(uploadFile);
                photoPath = uploadFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "Failed to upload the photo.");
                return "tenant_dashboard";  // Return back to the form on error
            }
        }

        // Create a MaintenanceRequest object from form inputs
        MaintenanceRequest request = new MaintenanceRequest();
       // request.setTenantId(tenantId);
        request.setRequestType(requestType);
        request.setDescription(description);
        request.setPhotoPath(photoPath);  // Optional photo
        request.setStatus("Pending");  // Initial status set to Pending

        // Call service method to submit the request
        try {
            maintenanceRequestService.submitRequest(request);
            model.addAttribute("success", "Your maintenance request has been submitted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Failed to submit the maintenance request.");
        }

        return "tenant_dashboard";  // Return the form view with a success message
    }
}
