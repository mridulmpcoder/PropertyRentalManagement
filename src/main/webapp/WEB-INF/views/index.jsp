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
                <li><a href="property.jsp">Property</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
            <div class="auth-links">
                <a href="register.jsp">Register</a>
                <a href="login.jsp">Login</a>
            </div>
        </nav>
    </header>
	
	<p><a href="/user/openLoginPage">Go to Login Page</a></p>

    <!-- Property Listing Section -->
    <section class="property">
        <div class="property-info">
            <h1>401 Biscayne Boulevard, Miami</h1>
            <h2>$1050/Month</h2>
            <p>For sale</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <ul>
                <li>3500 Sq Ft</li>
                <li>3 Beds</li>
                <li>3.5 Baths</li>
                <li>2 Garages</li>
            </ul>
            <a href="property-details.jsp" class="btn">Learn More</a>
        </div>
        <div class="property-image">
            <img src="images/property.jpg" alt="Property Image">
        </div>
    </section>

    <!-- Services Section -->
    <section class="services">
        <h2>Our Services</h2>
        <div class="service">
            <img src="images/service1.png" alt="Life Style">
            <h3>Life Style</h3>
            <p>Description of Life Style service.</p>
            <a href="service-details.jsp" class="btn">Learn More</a>
        </div>
        <div class="service">
            <img src="images/service2.png" alt="Shell">
            <h3>Shell</h3>
            <p>Description of Shell service.</p>
            <a href="service-details.jsp" class="btn">Learn More</a>
        </div>
        <div class="service">
            <img src="images/service3.png" alt="Loans">
            <h3>Loans</h3>
            <p>Description of Loans service.</p>
            <a href="service-details.jsp" class="btn">Learn More</a>
        </div>
    </section>

    <!-- Properties Section -->
    <section class="properties">
        <h2>Our Properties</h2>
        <div class="property-card">
            <img src="images/property1.jpg" alt="Property 1">
            <h3>405 Lock House, Goa</h3>
            <p>Rent: $45</p>
            <a href="property-details.jsp" class="btn">View All Details</a>
        </div>
        <div class="property-card">
            <img src="images/property2.jpg" alt="Property 2">
            <h3>Ganga Sagar House, Nashik</h3>
            <p>Rent: $45</p>
            <a href="property-details.jsp" class="btn">View All Details</a>
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
