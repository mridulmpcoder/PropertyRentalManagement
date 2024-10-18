package property_management.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import property_management.app.dao.TenantDao;
import property_management.app.entities.Tenant;


@Controller
public class TenantController {

    private final TenantDao tenantDao;

    @Autowired
    public TenantController(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    @GetMapping("/viewTenants")
    public String getAllTenants(Model model) {
        List<Tenant> tenantList = tenantDao.getAllTenants();
        model.addAttribute("tenantList", tenantList);
        return "view_tenants"; // Refers to view_tenants.jsp
    }

    @PostMapping("/assignTenant")
    public String assignTenantToProperty(@RequestParam int tenantId, @RequestParam int propertyId) {
        tenantDao.assignTenantToProperty(tenantId, propertyId);
        return "redirect:/viewTenants";
    }

    @PostMapping("/removeTenant")
    public String removeTenantFromProperty(@RequestParam int tenantId, @RequestParam int propertyId) {
        tenantDao.removeTenantFromProperty(tenantId, propertyId);
        return "redirect:/viewTenants";
    }
}
