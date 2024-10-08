package property_management.app.model;

public class Tenant {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String Contact;
	
	private java.sql.Date leaseStart;
    private java.sql.Date leaseExpiry;
    
    
    public String getFirstName() {
		return firstName;
	}
	
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public java.sql.Date getLeaseStart() {
		return leaseStart;
	}
	
	public void setLeaseStart(java.sql.Date leaseStart) {
		this.leaseStart = leaseStart;
	}
	
	
	public java.sql.Date getLeaseExpiry() {
		return leaseExpiry;
	}
	
	public void setLeaseExpiry(java.sql.Date leaseExpiry) {
		this.leaseExpiry = leaseExpiry;
	}
	
	public String getContact() {
		return Contact;
	}


	public void setContact(String contact) {
		Contact = contact;
	}




	
}
