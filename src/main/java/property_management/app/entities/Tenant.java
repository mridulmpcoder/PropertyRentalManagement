package property_management.app.entities;

import java.sql.Timestamp;

public class Tenant {
    private int tenantId;
    private String tenantType;  // enum('family','bachelor','working_bachelor')
    private int noOfPerson;
    private String tenantStatus;  // enum('active','terminated','pending')
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int propertyId;
    private int userId;

    // Getters and Setters
    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantType() {
        return tenantType;
    }

    public void setTenantType(String tenantType) {
        this.tenantType = tenantType;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public String getTenantStatus() {
        return tenantStatus;
    }

    public void setTenantStatus(String tenantStatus) {
        this.tenantStatus = tenantStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
