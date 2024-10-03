package property_management.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String tenantName;
    private String paymentStatus;    
    private BigDecimal amountDue;
    private LocalDate dueDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BigDecimal getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
    
    
    
    
    
}
//
//import java.math.BigDecimal;
//import java.sql.Date;
//
//
//
//
//public class Payment {
//	
//    private Long id;
//
//    private Tenant tenant;
//
//    private BigDecimal amount;
//    private Date dueDate;
//    private Date paidDate;
//    private String status;
//    private BigDecimal lateFee;
//    private String invoiceUrl;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Tenant getTenant() {
//		return tenant;
//	}
//	public void setTenant(Tenant tenant) {
//		this.tenant = tenant;
//	}
//	public BigDecimal getAmount() {
//		return amount;
//	}
//	public void setAmount(BigDecimal amount) {
//		this.amount = amount;
//	}
//	public Date getDueDate() {
//		return dueDate;
//	}
//	public void setDueDate(Date dueDate) {
//		this.dueDate = dueDate;
//	}
//	public Date getPaidDate() {
//		return paidDate;
//	}
//	public void setPaidDate(Date paidDate) {
//		this.paidDate = paidDate;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public BigDecimal getLateFee() {
//		return lateFee;
//	}
//	public void setLateFee(BigDecimal lateFee) {
//		this.lateFee = lateFee;
//	}
//	public String getInvoiceUrl() {
//		return invoiceUrl;
//	}
//	public void setInvoiceUrl(String invoiceUrl) {
//		this.invoiceUrl = invoiceUrl;
//	}
//    
//    
//
//    
//}
