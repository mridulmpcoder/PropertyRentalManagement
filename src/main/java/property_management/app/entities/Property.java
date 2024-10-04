package property_management.app.entities;

//public class Property {
//
//	private String propertyId;
//	private Landlord landlord;
//	private Building building;
//	private PropertyType propertyType;
//	private String name;
//	private int size;
//	private int noOfBedrooms;
//	private int noOfBathrooms;
//	private double rentAmount;
//	private String availability;
//
//	public Property() {
//		super();
//	}
//
//	public Property(String propertyId, Landlord landlord, Building building, PropertyType propertyType, String name,
//			int size, int noOfBedrooms, int noOfBathrooms, double rentAmount, String availability) {
//		super();
//		this.propertyId = propertyId;
//		this.landlord = landlord;
//		this.building = building;
//		this.propertyType = propertyType;
//		this.name = name;
//		this.size = size;
//		this.noOfBedrooms = noOfBedrooms;
//		this.noOfBathrooms = noOfBathrooms;
//		this.rentAmount = rentAmount;
//		this.availability = availability;
//	}
//
//	public Property(Landlord landlord, Building building, PropertyType propertyType, String name, int size,
//			int noOfBedrooms, int noOfBathrooms, double rentAmount, String availability) {
//		super();
//		this.landlord = landlord;
//		this.building = building;
//		this.propertyType = propertyType;
//		this.name = name;
//		this.size = size;
//		this.noOfBedrooms = noOfBedrooms;
//		this.noOfBathrooms = noOfBathrooms;
//		this.rentAmount = rentAmount;
//		this.availability = availability;
//	}
//
//	public String getPropertyId() {
//		return propertyId;
//	}
//
//	public void setPropertyId(String propertyId) {
//		this.propertyId = propertyId;
//	}
//
//	public Landlord getLandlord() {
//		return landlord;
//	}
//
//	public void setLandlord(Landlord landlord) {
//		this.landlord = landlord;
//	}
//
//	public Building getBuilding() {
//		return building;
//	}
//
//	public void setBuilding(Building building) {
//		this.building = building;
//	}
//
//	public PropertyType getPropertyType() {
//		return propertyType;
//	}
//
//	public void setPropertyType(PropertyType propertyType) {
//		this.propertyType = propertyType;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getSize() {
//		return size;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//
//	public int getNoOfBedrooms() {
//		return noOfBedrooms;
//	}
//
//	public void setNoOfBedrooms(int noOfBedrooms) {
//		this.noOfBedrooms = noOfBedrooms;
//	}
//
//	public int getNoOfBathrooms() {
//		return noOfBathrooms;
//	}
//
//	public void setNoOfBathrooms(int noOfBathrooms) {
//		this.noOfBathrooms = noOfBathrooms;
//	}
//
//	public double getRentAmount() {
//		return rentAmount;
//	}
//
//	public void setRentAmount(double rentAmount) {
//		this.rentAmount = rentAmount;
//	}
//
//	public String getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(String availability) {
//		this.availability = availability;
//	}
//
//	@Override
//	public String toString() {
//		return "Property [propertyId=" + propertyId + ", landlord=" + landlord + ", building=" + building
//				+ ", propertyType=" + propertyType + ", name=" + name + ", size=" + size + ", noOfBedrooms="
//				+ noOfBedrooms + ", noOfBathrooms=" + noOfBathrooms + ", rentAmount=" + rentAmount + ", availability="
//				+ availability + "]";
//	}
//
//}


import java.util.Base64;

public class Property {
    private int propertyId;              // Renamed for consistency
    private String title;
    private String description;
    private String location;
    private String type;                 // Consider clarifying this if necessary
    private Double price;            // Changed to BigDecimal for financial precision
    private byte[] imageBlob;            // Binary data for image

    // Facilities represented as separate boolean fields for better control
    private boolean swimmingPool;
    private boolean gym;
    private boolean parking;
    private boolean garden;
    private boolean airConditioning;
    private boolean elevator;
    private boolean securitySystem;
    private boolean internet;
    private boolean furnished;

    // Default constructor
    public Property() {}

    // Parameterized constructor for easy instantiation
    public Property(int propertyId, String title, String description, String location, String type, Double price, byte[] imageBlob) {
        this.propertyId = propertyId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.price = price;
        this.imageBlob = imageBlob;
    }

    // Getters and setters

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isSecuritySystem() {
        return securitySystem;
    }

    public void setSecuritySystem(boolean securitySystem) {
        this.securitySystem = securitySystem;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public String getImageAsBase64() {
        if (imageBlob != null && imageBlob.length > 0) {
            return Base64.getEncoder().encodeToString(imageBlob);
        }
        return ""; // Return an empty string if there's no image
    }


    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", swimmingPool=" + swimmingPool +
                ", gym=" + gym +
                ", parking=" + parking +
                ", garden=" + garden +
                ", airConditioning=" + airConditioning +
                ", elevator=" + elevator +
                ", securitySystem=" + securitySystem +
                ", internet=" + internet +
                ", furnished=" + furnished +
                '}';
    }

    // Override equals and hashCode as needed for collection handling
}
