<%@page import="java.util.Base64"%>
<%@page import="property_management.app.entities.Property"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Property Management</title>
<!-- Linking the CSS file -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<head>
<title>View Properties</title>
</head>
<body>


<h2>Property Details</h2>
<%
    Property property = (Property) request.getAttribute("property");
%>

<% if (property != null) { %>
    <p>Title: <%= property.getTitle() %></p>
    <p>Description: <%= property.getDescription() %></p>
    <p>Location: <%= property.getLocation() %></p>
    <p>Type: <%= property.getType() %></p>
    <p>Price: <%= property.getPrice() %></p>
    <p>Status: <%= property.getStatus() %></p>
    <p>Amenities:</p>
    <ul>
        <li>Swimming Pool: <%= property.isSwimmingPool() ? "Yes" : "No" %></li>
        <li>Gym: <%= property.isGym() ? "Yes" : "No" %></li>
        <li>Garden: <%= property.isGarden() ? "Yes" : "No" %></li>
        <li>Parking: <%= property.isParking() ? "Yes" : "No" %></li>
        <li>Air Conditioning: <%= property.isAirConditioning() ? "Yes" : "No" %></li>
        <li>Elevator: <%= property.isElevator() ? "Yes" : "No" %></li>
        <li>Security System: <%= property.isSecuritySystem() ? "Yes" : "No" %></li>
        <li>Internet: <%= property.isInternet() ? "Yes" : "No" %></li>
        <li>Furnished: <%= property.isFurnished() ? "Yes" : "No" %></li>
    </ul>
    <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(property.getImage()) %>" width="200" height="200" />
<% } else { %>
    <p>Property not found.</p>
<% } %>

</body>
</html>
