package property_management.app.controller;




import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javafx.beans.property.Property;
import property_management.app.dao.ManagerDao;
import property_management.app.dao.ManagerDaoImpl;
import property_management.app.dao.PropertyDao;
import property_management.app.dao.PropertyDaoImpl;
import property_management.app.model.*;


@WebServlet("/managerAssignment")
public class ManagerAssignmentController extends HttpServlet {
    private PropertyDao propertyDAO = new PropertyDaoImpl();
    private ManagerDao managerDAO = new ManagerDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<property_management.app.model.Property> properties = PropertyDao.getAllProperties();
            List<Manager> managers = ManagerDao.getAllManagers();

            request.setAttribute("properties", properties);
            request.setAttribute("managers", managers);

            RequestDispatcher dispatcher = request.getRequestDispatcher("manager_assignment.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching data.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String propertyId = request.getParameter("propertyId");
        String managerId = request.getParameter("managerId");

        try {
            // Logic to assign the manager to the property
            // e.g., propertyDAO.assignManager(propertyId, managerId);
            propertyDAO.assignManager(propertyId, managerId); // Make sure this method exists in your DAO

            request.setAttribute("message", "Manager assigned successfully!");
            doGet(request, response); // Re-fetch properties and managers to show updated state
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error assigning manager.");
            doGet(request, response); // Show the form again with the error message
        }
    }
}
