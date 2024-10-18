package property_management.app.entities;



public class Manager {
    
    private int managerId;
    private int experience_years; // Assuming experience is an integer
    private String resume;
    private boolean approved;

    
    public Manager() {
		super();
	}


	// Constructor
    public Manager( int managerId, int experience_years, String resume) {
        
        this.managerId = managerId;
        this.experience_years = experience_years;
        this.resume = resume;
    }

    
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    

    public int getExperience_years() {
		return experience_years;
	}

	public void setExperience_years(int experience_years) {
		this.experience_years = experience_years;
	}

	public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", experience_years=" + experience_years + ", resume=" + resume
				+ ", approved=" + approved + ", getManagerId()=" + getManagerId() + ", getExperience_years()="
				+ getExperience_years() + ", getResume()=" + getResume() + ", isApproved()=" + isApproved() + "]";
	}


	
    
	
}
