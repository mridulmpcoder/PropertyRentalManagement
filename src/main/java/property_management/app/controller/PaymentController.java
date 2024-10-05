package property_management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import property_management.app.model.Payment;

import property_management.app.service.PaymentService;

@RestController
@RequestMapping("/api/payments") 
public class PaymentController { 
    @Autowired 
    private PaymentService paymentService; 
 
    @GetMapping("/payments")
    public String getPayments(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "paymentManagement"; 
    } 
 
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) { 
        return paymentService.savePayment(payment); 
    } 
 
    @DeleteMapping("/{id}") 
    public void deletePayment(@PathVariable Long id) { 
        paymentService.deletePayment(id); 
    } 
}