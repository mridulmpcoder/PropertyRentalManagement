<%@ page import="java.util.List" %>
<%@ page import="property_management.app.entities.Property" %>

<%
    List<Property> properties = (List<Property>) request.getAttribute("properties");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property Management System - Properties</title>
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <!-- Constant Navigation Bar -->
    <nav class="navbar">
        <div class="navbar-container">
            <a href="#" class="logo">Property Management</a>
            <ul class="nav-links">
                <li><a href="/TenantHomePage">Home</a></li>
                <li><a href="/properties">Properties</a></li>
                <li><a href="/aboutUs">About Us</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/user/openLoginPage" class="login-btn">Login</a></li>
            </ul>
        </div>
    </nav>

    <!-- Cards Section: Property Listings -->
    <section class="cards-container">
        <div class="cards-title">
            <h2>Available Properties</h2>
        </div>

        <div class="cards">
            <!-- If no properties are available, show a message -->
            <% if (properties == null || properties.isEmpty()) { %>
                <p>No properties available at the moment.</p>
            <% } else { %>
                <!-- Loop through properties and display each one as a card -->
                <% for (Property property : properties) { %>
                    <div class="card">
                        <!-- Property Image: Handling Base64 encoded image from property -->
                        <img src="<%= (property.getImageAsBase64() != null && !property.getImageAsBase64().isEmpty()) ? "data:image/jpeg;base64," + property.getImageAsBase64() : "/resources/images/default-property.jpg" %>" alt="Image of <%= property.getTitle() %>">
                        
                        <!-- Property Title -->
                        <h3><%= property.getTitle() %></h3>

                        <!-- Property Description -->
                        <p><%= property.getDescription() %></p>

                        <!-- Property Price -->
                        <p>Price: $<%= String.format("%.2f", property.getPrice()) %></p>

                        <!-- Property Details Button -->
                        <a href="${pageContext.request.contextPath}/user/PropertyDetails/<%= property.getPropertyId() %>" class="btn-secondary">View Details</a>
                    </div>
                <% } %>
            <% } %>
        </div>
    </section>

    <!-- Footer Section -->
    <footer class="footer">
        <div class="footer-content">
            <div class="footer-left">
                <h3>Property Management</h3>
                <p>Your one-stop solution for managing and finding properties.</p>
            </div>
            <div class="footer-right">
                <ul class="social-icons">
                    <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                    <li><a href="#"><i class="fab fa-linkedin"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 Property Management System. All Rights Reserved.</p>
        </div>
    </footer>

</body>
</html>
