<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="property_management.app.entities.Manager" %>
<%@ page import="java.util.List" %>
 
<%

    List<Manager> managers = (List<Manager>) request.getAttribute("managers");

    

%>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Managers</title>
</head>
<body>
<h1>Manage Managers</h1>
 
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
<tr>
<th>Manager ID</th>
<th>Experience (Years)</th>
<th>Status</th>
<th>Actions</th>
</tr>
<%

            if (managers != null && !managers.isEmpty()) {

                for (Manager manager : managers) {

        %>
<tr>
<td><%= manager.getManagerId() %></td>
<td><%= manager.getExperience_years() %></td>
<td><%= manager.isApproved() ? "Approved" : "Pending" %></td>
<td>
<form action="<%= request.getContextPath() + "/approveManager" %>" method="POST" style="display:inline;">
<input type="hidden" name="managerId" value="<%= manager.getManagerId() %>"/>
<button type="submit">Approve</button>
</form>

<form action="<%= request.getContextPath() + "/rejectManager" %>" method="POST" style="display:inline;">
<input type="hidden" name="managerId" value="<%= manager.getManagerId() %>"/>
<button type="submit">Reject</button>
</form>
</td>
</tr>
<%

                }

            } else {

        %>
<tr>
<td colspan="4">No managers available at the moment.</td>
</tr>
<%

            }

        %>
</table>
 
<form action="/landlord/manageManagers" method="get">
<button type="submit">Go to Manage Managers</button>
</form>


</body>
</html>

 