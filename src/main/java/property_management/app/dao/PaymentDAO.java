package property_management.app.dao;

import property_management.app.entities.Payment;

public interface PaymentDAO {    
	
	void savePayment(Payment payment);
}