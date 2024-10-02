package property_management.app.entities;

public class Property {

	private String propertyId;
	private Landlord landlord;
	private Building building;
	private PropertyType propertyType;
	private String name;
	private int size;
	private int noOfBedrooms;
	private int noOfBathrooms;
	private double rentAmount;
	private String availability;

	public Property() {
		super();
	}

	public Property(String propertyId, Landlord landlord, Building building, PropertyType propertyType, String name,
			int size, int noOfBedrooms, int noOfBathrooms, double rentAmount, String availability) {
		super();
		this.propertyId = propertyId;
		this.landlord = landlord;
		this.building = building;
		this.propertyType = propertyType;
		this.name = name;
		this.size = size;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.rentAmount = rentAmount;
		this.availability = availability;
	}

	public Property(Landlord landlord, Building building, PropertyType propertyType, String name, int size,
			int noOfBedrooms, int noOfBathrooms, double rentAmount, String availability) {
		super();
		this.landlord = landlord;
		this.building = building;
		this.propertyType = propertyType;
		this.name = name;
		this.size = size;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.rentAmount = rentAmount;
		this.availability = availability;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}

	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", landlord=" + landlord + ", building=" + building
				+ ", propertyType=" + propertyType + ", name=" + name + ", size=" + size + ", noOfBedrooms="
				+ noOfBedrooms + ", noOfBathrooms=" + noOfBathrooms + ", rentAmount=" + rentAmount + ", availability="
				+ availability + "]";
	}

}
