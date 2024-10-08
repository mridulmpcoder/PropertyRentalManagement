package property_management.app.repository;


import property_management.app.entities.PropertyManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<PropertyManager, String> {
}



