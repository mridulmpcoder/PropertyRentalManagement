package property_management.app.entities;

import java.math.BigDecimal;
import java.util.Date;

public class LeaseAgreement {
    private int leaseId;
    private int tenantId;          // Foreign key to Tenant
    private int propertyId;        // Foreign key to Property
    private Date leaseStartDate;
    private Date leaseEndDate;
    private BigDecimal rentAmount;
    private BigDecimal depositAmount;
    private String paymentSchedule;
    private String agreementDetails;

    // Default constructor
    public LeaseAgreement() {}

    // Parameterized constructor
    public LeaseAgreement(int leaseId, int tenantId, int propertyId, Date leaseStartDate, Date leaseEndDate,
                          BigDecimal rentAmount, BigDecimal depositAmount, String paymentSchedule, String agreementDetails) {
        this.leaseId = leaseId;
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.rentAmount = rentAmount;
        this.depositAmount = depositAmount;
        this.paymentSchedule = paymentSchedule;
        this.agreementDetails = agreementDetails;
    }

    // Getters and setters

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getAgreementDetails() {
        return agreementDetails;
    }

    public void setAgreementDetails(String agreementDetails) {
        this.agreementDetails = agreementDetails;
    }

    @Override
    public String toString() {
        return "LeaseAgreement{" +
                "leaseId=" + leaseId +
                ", tenantId=" + tenantId +
                ", propertyId=" + propertyId +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", rentAmount=" + rentAmount +
                ", depositAmount=" + depositAmount +
                ", paymentSchedule='" + paymentSchedule + '\'' +
                ", agreementDetails='" + agreementDetails + '\'' +
                '}';
    }

    // Override equals and hashCode as needed
}
