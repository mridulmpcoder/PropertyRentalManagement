package property_management.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "property_manager") // Adjusted to match your table name
public class PropertyManager {
    @Id
    private String id; // This should match the primary key in your table

    private String name; // This should match the name column in your table

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
