package property_management.app.entities;



public class Tenant {
    private int tenantId;
    private String tenantType;
    private int noOfPerson;
    private boolean tenantStatus;

    // Constructor, Getters, and Setters
    public Tenant(int tenantId, String tenantType, int noOfPerson,boolean tenantStatus) {
        this.tenantId = tenantId;
        this.tenantType = tenantType;
        this.noOfPerson = noOfPerson;
        this.tenantStatus = tenantStatus;
    }
    
    

	public Tenant() {
		super();
	}



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

	public boolean isTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(boolean tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantType=" + tenantType + ", noOfPerson=" + noOfPerson
				+ ", tenantStatus=" + tenantStatus + ", getTenantId()=" + getTenantId() + ", getTenantType()="
				+ getTenantType() + ", getNoOfPerson()=" + getNoOfPerson() + ", isTenantStatus()=" + isTenantStatus()
				+ "]";
	}
	
	

    // Getters and Setters ...
}
