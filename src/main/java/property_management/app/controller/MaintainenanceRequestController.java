package property_management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import property_management.app.entities.MaintenanceRequest;
import property_management.app.dao.MaintenanceRequestDao;

import java.time.LocalDateTime;

public class MaintainenanceRequestController {

	@Autowired
	private MaintenanceRequestDao maintenanceDao;

	@PostMapping("/api/maintenance/submit")
	public ResponseEntity<String> submitRequest(@RequestParam("request_type") String requestType,
			@RequestParam("description") String description, @RequestParam("photo") MultipartFile photo,
			@RequestParam("tenantId") Long tenantId) {
		try {
			MaintenanceRequest request = new MaintenanceRequest();
			request.setRequestType(requestType);
			request.setDescription(description);
			request.setTenantId(tenantId);
			request.setRequestedDate(LocalDateTime.now());
			request.setStatus("Received");

			if (!photo.isEmpty()) {
				byte[] photoBytes = photo.getBytes();
				request.setPhoto(photoBytes);
			}

			maintenanceDao.saveRequest(request);
			return ResponseEntity.ok("Request is submitted successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to submit the request: " + e.getMessage());
		}
	}

}
