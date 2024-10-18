<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@ page import="java.util.List" %>
<%@ page import="property_management.app.model.MaintenanceRequest" %>
<%@ page import="property_management.app.dao.MaintenanceRequestDao" %>
<%@ page import="property_management.app.dao.MaintenanceRequestDaoImpl" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maintenance Requests</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Maintenance Requests</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Description</th>
                <th>Status</th>
                <th>Requested Date</th>
                <th>Final Cost</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<MaintenanceRequest> requests = (List<MaintenanceRequest>) request.getAttribute("requests");
           
                for (MaintenanceRequest maintenanceRequest : requests) {
            %>
            <tr>
                <td><%= maintenanceRequest.getMaintenanceId() %></td>
                <td><%= maintenanceRequest.getRequestType() %></td>
                <td><%= maintenanceRequest.getDescription() %></td>
                <td><%= maintenanceRequest.getStatus() %></td>
                <td><%= maintenanceRequest.getRequestedDate() %></td>
                <td><%= maintenanceRequest.getFinalCost() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
