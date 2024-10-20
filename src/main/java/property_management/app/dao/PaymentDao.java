package property_management.app.dao;

import java.util.List;

import property_management.app.entities.Payment;

public interface PaymentDao {

	void savePayment(Payment payment);

	List<Payment> fetchPaymentsByTenantId(Long tenantId);
}
