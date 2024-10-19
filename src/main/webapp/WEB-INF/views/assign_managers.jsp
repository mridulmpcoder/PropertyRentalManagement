<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="property_management.app.entities.Manager" %>
<%@ page import="property_management.app.entities.Property"%>
<%@ page import="java.util.List"%>

<%
    List<Manager> approvedManagers = (List<Manager>) request.getAttribute("approvedManagers");
    List<Property> properties = (List<Property>) request.getAttribute("properties");
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign Manager</title>
</head>
<body>
<h1>Assign/Remove Manager to Property</h1>

<%
    if (message != null && !message.isEmpty()) {
%>
<div style="color: green;">
    <%= message %>
</div>
<%
    }
%>

<form action="<%= request.getContextPath() + "/assignManager" %>" method="POST">
    <label for="managerId">Select Approved Manager:</label>
    <select name="managerId" id="managerId">
        <%
            if (approvedManagers != null && !approvedManagers.isEmpty()) {
                for (Manager manager : approvedManagers) {
        %>
            <option value="<%= manager.getManagerId() %>"><%= manager.getExperience_years() %></option>
        <%
                }
            } else {
        %>
            <option value="">No approved managers available</option>
        <%
            }
        %>
    </select>

    <label for="propertyId">Select Property:</label>
    <select name="propertyId" id="propertyId">
        <%
            if (properties != null && !properties.isEmpty()) {
                for (Property property : properties) {
        %>
            <option value="<%= property.getPropertyId() %>"><%= property.getTitle() %></option>
        <%
                }
            } else {
        %>
            <option value="">No properties available</option>
        <%
            }
        %>
    </select>

    <button type="submit">Assign Manager</button>
</form>

<h2>Currently Assigned Managers</h2>
<table border="1">
    <tr>
        <th>Property ID</th>
        <th>Property Title</th>
        <th>Assigned Manager</th>
        <th>Actions</th>
    </tr>
    <%
        if (properties != null && !properties.isEmpty()) {
            for (Property property : properties) {
                if (property.getManagerId() !=0) {
        %>
    <tr>
        <td><%= property.getPropertyId() %></td>
        <td><%= property.getTitle() %></td>
        <td><%= property.getManagerId() %></td>
        <td>
            <form action="<%= request.getContextPath() + "/unassignManager" %>" method="POST" style="display:inline;">
                <input type="hidden" name="propertyId" value="<%= property.getPropertyId() %>"/>
                <button type="submit">Remove Manager</button>
            </form>
        </td>
    </tr>
    <%
                }
            }
        } else {
    %>
    <tr>
        <td colspan="4">No properties available.</td>
    </tr>
    <%
        }
    %>
</table>

<form action="/landlord/manageManagers" method="GET">
    <button type="submit">Go to Manage Managers</button>
</form>

</body>
</html>