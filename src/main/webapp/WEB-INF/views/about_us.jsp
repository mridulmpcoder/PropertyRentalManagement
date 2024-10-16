<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property Management System - Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homestyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

	<!-- Constant Navigation Bar -->
	   <nav class="navbar">
	       <div class="navbar-container">
	           <a href="#" class="logo">Property Management</a>
	           <ul class="nav-links">
	               <li><a href="/TenantHomePage">Home</a></li>
	               <li><a href="/PropertyPage">Properties</a></li>
	               <li><a href="user/AboutUs">About Us</a></li>
	               <li><a href="/contact">Contact</a></li>
	               <li><a href="/user/openLoginPage" class="login-btn">Login</a></li>
	           </ul>
	       </div>
	   </nav>

    <!-- About Us Section -->
    <section class="about-section">
        <div class="about-container">
            <div class="about-content">
                <h2>Welcome to Our Tenant Management System</h2>
                <p>Our tenant management system offers an easy-to-use platform for managing rental properties, tenants, and related operations. As a single landlord, we are dedicated to providing a seamless experience for all prospective tenants, ensuring a streamlined process from viewing properties to signing leases.</p>
                <p>With a range of residential properties across the city, we cater to various needs—whether you're looking for an apartment, a villa, or a cozy family home. Our goal is to provide high-quality rental options that prioritize comfort, safety, and modern living.</p>
                <a href="/PropertyPage" class="btn-primary">Explore Our Properties</a>
            </div>
            <div class="about-image">
                <img src="images/about-us.jpg" alt="About Us">
            </div>
        </div>
    </section>

    <!-- Why Choose Us Section -->
    <section class="why-choose-us">
        <h2>Why Choose Us?</h2>
        <div class="why-choose-us-container">
            <div class="why-card">
                <h3>Reliability</h3>
                <p>We ensure transparency and reliability in all our dealings. Tenants can trust us for hassle-free property management and clear communication.</p>
            </div>
            <div class="why-card">
                <h3>Property Quality</h3>
                <p>All our properties are well-maintained, with a focus on modern amenities, safety, and comfort. We offer homes that meet high standards of living.</p>
            </div>
            <div class="why-card">
                <h3>Easy Process</h3>
                <p>From finding the right property to completing lease agreements, our process is designed to be quick, simple, and stress-free.</p>
            </div>
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
