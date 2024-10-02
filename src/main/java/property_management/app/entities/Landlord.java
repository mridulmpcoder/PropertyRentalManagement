package property_management.app.entities;

public class Landlord {

	private String landlordId;
	private User user;

	public Landlord() {
		super();
	}

	public Landlord(String landlordId, User user) {
		super();
		this.landlordId = landlordId;
		this.user = user;
	}

	public String getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", user=" + user + "]";
	}

}
