<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate JSP Example</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <!-- Header with dynamic user login -->
    <header>
        <div class="top-bar">
            <p>
                <% 
                    String user = (String) session.getAttribute("username");
                    if (user != null) {
                        out.print("Hello, " + user + "!");
                    } else {
                        out.print("Hello User, please login for better experience.");
                    }
                %>
            </p>
        </div>

        <nav>
            <div class="logo">
                <img src="images/logo.png" alt="Logo">
            </div>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="/user/openLandlordDashboard">Property</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
            <div class="auth-links">
                <a href="/user/openRegistrationPage">Register</a>
                <a href="/user/openLoginPage">Login</a>
            </div>
        </nav>
    </header>
	
    <!-- Property Listing Section -->
    <section class="card-section">
        <div class="card">
            <h1>Property: 401 Biscayne Boulevard</h1>
            <h2>$1050/Month - For Rent</h2>
            <p>Size: 3500 Sq Ft, 3 Beds, 3.5 Baths, 2 Garages</p>
            <a href="property-details.jsp" class="btn">Learn More</a>
        </div>
    </section>

   

    <!-- Footer -->
    <footer>
        <div class="footer-container">
            <div class="footer-section">
                <h3>RKRent.com</h3>
                <p>Contact us: contact@example.com</p>
            </div>
            <div class="footer-section">
                <h3>The Service</h3>
                <ul>
                    <li><a href="sitemap.jsp">Site Map</a></li>
                    <li><a href="privacy.jsp">Privacy Policy</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>International Sites</h3>
                <ul>
                    <li><a href="china.jsp">China</a></li>
                    <li><a href="argentina.jsp">Argentina</a></li>
                </ul>
            </div>
        </div>
    </footer>

</body>
</html>
