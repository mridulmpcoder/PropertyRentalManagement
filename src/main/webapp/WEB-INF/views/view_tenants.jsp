<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="property_management.app.entities.Tenant" %>
<%@ page import="java.util.List" %>

<%
    List<Tenant> tenantList = (List<Tenant>) request.getAttribute("tenantList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Tenants</title>
</head>
<body>
<h1>Manage Tenants</h1>

<%
    String message = (String) request.getAttribute("message");
    if (message != null && !message.isEmpty()) {
%>
    <div style="color: green;">
        <%= message %>
    </div>
<%
    }
%>

<table border="1">
    <thead>
        <tr>
            <th>Tenant ID</th>
            <th>Type</th>
            <th>No. of Persons</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
<%
    if (tenantList != null && !tenantList.isEmpty()) {
        for (Tenant tenant : tenantList) {
%>
        <tr>
            <td><%= tenant.getTenantId() %></td>
            <td><%= tenant.getTenantType() %></td>
            <td><%= tenant.getNoOfPerson() %></td>
            <td><%= tenant.isTenantStatus() ? "Approved" : "Pending" %></td>
            <td>
                <form action="<%= request.getContextPath() + "/assignTenant" %>" method="POST" style="display:inline;">
                    <input type="hidden" name="tenantId" value="<%= tenant.getTenantId() %>">
                    <input type="number" name="propertyId" placeholder="Property ID" required>
                    <button type="submit">Assign</button>
                </form>
                
                <form action="<%= request.getContextPath() + "/removeTenant" %>" method="POST" style="display:inline;">
                    <input type="hidden" name="tenantId" value="<%= tenant.getTenantId() %>">
                    <input type="number" name="propertyId" placeholder="Property ID" required>
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
<%
        }
    } else {
%>
        <tr>
            <td colspan="5">No tenants found.</td>
        </tr>
<%
    }
%>
    </tbody>
</table>
</body>
</html>
