package property_management.app.dao;

import property_management.app.entities.Payment;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	private final JdbcTemplate jdbcTemplate;

	public PaymentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void savePayment(Payment payment) {
		String sql = "INSERT INTO payment (tenant_id, payment_method, price, payment_date, receipt, manager_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, payment.getTenantId(), payment.getPaymentMethod(), payment.getPrice(),
				payment.getPaymentDate(), payment.getReceipt(), payment.getManagerId()); // Ensure to include manager_id
																							// if it's a part of your
																							// Payment entity
	}

	@Override
	public List<Payment> fetchPaymentsByTenantId(Long tenantId) {
		String sql = "SELECT p.payment_id, p.tenant_id, p.amount, p.payment_method, p.payment_date, t.first_name, t.last_name, pr.title "
				+ "FROM payment p " + "JOIN tenant t ON p.tenant_id = t.tenant_id "
				+ "JOIN property pr ON p.property_id = pr.property_id " + "WHERE p.tenant_id = ?";

		return jdbcTemplate.query(sql, new Object[] { tenantId }, new PaymentRowMapper());
	}
}