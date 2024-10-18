package property_management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import property_management.app.entities.Landlord;
import property_management.app.entities.Payment;
import property_management.app.dao.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

	@Autowired
	private PaymentDAO paymentDAO;

	@Autowired
	private LandlordDAO landlordDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	@GetMapping("/api/payment/details")
	public ResponseEntity<Payment> getPaymentDetails(@RequestParam("tenantId") Long tenantId) {
		Landlord landlord = landlordDAO.getLandlordDetails();

		if (landlord == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		// Fetch amount from the property table (Assuming you have a method for this)
		double amount = propertyDAO.getAmountByTenantId(tenantId); // This method should be implemented in your
																	// PropertyDAO

		// Create the PaymentDetails model
		Payment paymentDetails = new Payment();
		paymentDetails.setBankDetails(landlord.getBankDetails());
		paymentDetails.setUpiDetails(landlord.getUpiDetails());
		paymentDetails.setAmount(amount);

		return ResponseEntity.ok(paymentDetails);
	}

	@PostMapping("/api/payment/submit")
	public ResponseEntity<String> submitPayment(@RequestParam("tenantId") Long tenantId,
			@RequestParam("payment_method") String paymentMethod, @RequestParam("amount") Double amount,
			@RequestParam(value = "receipt", required = false) MultipartFile receipt) {

		try {
			Long managerId = (long) 1; // Replace with actual logic to retrieve manager ID

			// Validate input parameters
			if (tenantId == null || amount == null || paymentMethod == null || managerId == null) {
				return ResponseEntity.badRequest().body("Required fields are missing.");
			}

			// Trim and validate payment method length
			paymentMethod = paymentMethod.trim();
			if (paymentMethod.length() > 50) { // Adjust based on your database schema
				return ResponseEntity.badRequest().body("Payment method exceeds maximum length.");
			}

			Payment payment = new Payment();
			payment.setTenantId(tenantId);
			payment.setPaymentMethod(paymentMethod); // Set trimmed value
			payment.setPrice(amount);
			payment.setPaymentDate(LocalDate.now());
			payment.setManagerId(managerId);

			if (receipt != null && !receipt.isEmpty()) {
				byte[] receiptBytes = receipt.getBytes();
				payment.setReceipt(receiptBytes);
			}

			paymentDAO.savePayment(payment);

			return ResponseEntity.ok("Payment submitted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to submit payment: " + e.getMessage());
		}
	}

}