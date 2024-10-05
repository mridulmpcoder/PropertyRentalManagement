package property_management.app.entities;

public class PropertyManager {
	
	    private int managerId;
	    private String managerName;
	    private String managerEmail;
	    private String managerPhone;
	 
	    // Constructor
	    public PropertyManager(int managerId, String managerName, String managerEmail, String managerPhone) {
	        this.managerId = managerId;
	        this.managerName = managerName;
	        this.managerEmail = managerEmail;
	        this.managerPhone = managerPhone;
	    }
	 
	    // Getters and Setters
	    public int getManagerId() {
	        return managerId;
	    }
	 
	    public void setManagerId(int managerId) {
	        this.managerId = managerId;
	    }
	 
	    public String getManagerName() {
	        return managerName;
	    }
	 
	    public void setManagerName(String managerName) {
	        this.managerName = managerName;
	    }
	 
	    public String getManagerEmail() {
	        return managerEmail;
	    }
	 
	    public void setManagerEmail(String managerEmail) {
	        this.managerEmail = managerEmail;
	    }
	 
	    public String getManagerPhone() {
	        return managerPhone;
	    }
	 
	    public void setManagerPhone(String managerPhone) {
	        this.managerPhone = managerPhone;
	    }
	}
	 

