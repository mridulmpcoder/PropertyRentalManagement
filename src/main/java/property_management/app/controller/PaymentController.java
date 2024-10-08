//package property_management.app.controller;
//
//import property_management.app.model.Payment;
//import property_management.app.service.PaymentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class PaymentController {
//
//	private final PaymentService paymentService;
//
//	public PaymentController(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}
//
//	// End point to retrieve tenant payment history
//	@GetMapping("/tenant/payments")
//	public String getPaymentHistory(@RequestParam("tenantId") int tenantId, Model model) {
//		// Fetch payment history from service
//		List<Payment> payments = paymentService.getPaymentHistory(tenantId);
//
//		// Add payment data to the model
//		model.addAttribute("payments", payments);
//
//		// Return the payment page view
//		return "payment_page"; // This should map to your JSP page
//	}
//}
