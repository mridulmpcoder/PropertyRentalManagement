package property_management.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import property_management.app.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import property_management.app.model.Tenant;

@WebServlet("/TenantController")
public class TenantController extends HttpServlet {
    private TenantDao tenantDAO = new TenantDaoImpl();

    @PostMapping()
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("Add Tenant".equals(action)) {
                Tenant tenant = new Tenant();
                
                tenant.setFirstName(request.getParameter("First name"));
                tenant.setLastName(request.getParameter("Last name"));
                tenant.setEmail(request.getParameter("email"));
                tenant.setContact(request.getParameter("Contact"));
                
                tenant.setLeaseStart(java.sql.Date.valueOf(request.getParameter("lease_start")));
                tenant.setLeaseExpiry(java.sql.Date.valueOf(request.getParameter("lease_expiry")));

                tenantDAO.addTenant(tenant);
                request.setAttribute("message", "Tenant added successfully!");
                response.sendRedirect("manage_tenants.jsp");
            } else if ("Delete Tenant".equals(action)) {
                int tenantId = Integer.parseInt(request.getParameter("tenant_id"));
                tenantDAO.deleteTenant(tenantId);
                request.setAttribute("message", "Tenant removed successfully!");
                response.sendRedirect("manage_tenants.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Tenant> tenantList = tenantDAO.getAllTenants();
            request.setAttribute("tenants", tenantList);
            request.getRequestDispatcher("manage_tenants.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching tenants.");
        }
    }
}
