package property_management.app.entities;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class MaintenanceRequest {
    private int maintenanceId;
    private String requestType;
    private String description;
    private byte[] photo;
    private String status;
    private Integer userId;
    private Integer managerId;
    private Integer tenantId;
    private Timestamp requestedDate;
    private Timestamp resolvedDate;
    private BigDecimal finalCost;
    
	public int getMaintenanceId() {
		return maintenanceId;
	}
	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getTenantId() {
		return tenantId;
	}
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public Timestamp getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(Timestamp requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Timestamp getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(Timestamp resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public BigDecimal getFinalCost() {
		return finalCost;
	}
	public void setFinalCost(BigDecimal finalCost) {
		this.finalCost = finalCost;
	}
    
    // Getters and Setters
    // (Omitted for brevity; generate these using your IDE)
}