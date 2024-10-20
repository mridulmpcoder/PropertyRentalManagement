package property_management.app.entities;

import java.time.LocalDateTime;

public class MaintenanceRequest {
	private Long maintenanceId;
	private String requestType;
	private String description;
	private byte[] photo;
	private String status;
	private Long userId;
	private Long managerId;
	private Long tenantId;
	private LocalDateTime requestedDate;
	private LocalDateTime resolvedDate;
	private Double finalCost;

	public MaintenanceRequest() {
	}

	// Constructor with fields
	public MaintenanceRequest(String requestType, String description, byte[] photo, String status, Long userId,
			Long managerId, Long tenantId, LocalDateTime requestedDate, LocalDateTime resolvedDate, Double finalCost) {
		this.requestType = requestType;
		this.description = description;
		this.photo = photo;
		this.status = status;
		this.userId = userId;
		this.managerId = managerId;
		this.tenantId = tenantId;
		this.requestedDate = requestedDate;
		this.resolvedDate = resolvedDate;
		this.finalCost = finalCost;
	}

	// Getters and setters
	public Long getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(Long maintenanceId) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public LocalDateTime getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDateTime requestedDate) {
		this.requestedDate = requestedDate;
	}

	public LocalDateTime getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public Double getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(Double finalCost) {
		this.finalCost = finalCost;
	}
}