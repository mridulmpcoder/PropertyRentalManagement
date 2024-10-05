package property_management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property_management.app.model.Payment;
import property_management.app.repository.PaymentRepository;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository = null;

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
}