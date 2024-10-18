<%@ page import="property_management.app.entities.Property"%>
<%@page import="property_management.app.entities.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description"
	content="View Property Details - Tenant Management System" />
<title>View Property | Tenant Management System</title>
    <link href="${pageContext.request.contextPath}/css/homestyle.css" rel="stylesheet"/>
<style>
/* property-details.css */

/* Body styling */
body {
	background-image: url("/images/b70e6ixf.png");
	/* Replace with your actual image path */
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	font-family: "Arial", sans-serif;
	color: #333;
	margin: 0;
	padding: 0;
	line-height: 1.6;
	min-height: 200vh;
	overflow-y: auto;
}

/* Header styling */
header {
	background-color: rgba(240, 241, 243, 0.8);
	color: black;
	padding: 20px;
	text-align: center;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
	position: relative;
	margin-top: 70px;
}

/* Property details styling */
.my-property-details {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background: white;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.my-property-details h2 {
	color: #333;
}

.my-property-details img {
	max-width: 100%;
	height: auto;
	border-radius: 10px;
}

.my-property-info {
	margin: 20px 0;
}

.btn-back {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.btn-back:hover {
	background-color: #0056b3;
}

.my-facility-list {
	list-style-type: none;
	padding: 0;
}

.facility-item {
	display: flex;
	align-items: center;
}

.facility-icon {
	margin-right: 10px;
}

.social-icons {
	list-style: none;
	padding: 0;
}

.social-icons li {
	display: inline;
	margin-right: 10px;
}

body {
	background-image:
		url("/images/wallpapersden.com_gradient-landscape-4k-illustration_2048x1512.jpg");
	/* Replace with your actual image path */
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	font-family: "Arial", sans-serif;
	color: #333;
	margin: 0;
	padding: 0;
	line-height: 1.6;
	min-height: 200vh;
	overflow-y: auto;
}

.social-icons {
	list-style: none;
	padding: 0;
}

.social-icons li {
	display: inline;
	margin-right: 10px;
}
</style>
<link rel="stylesheet" href="/property-details.css" />
<!-- Link to external CSS -->
</head>
<body>
	<!-- Constant Navigation Bar -->
	<nav class="navbar">
		<div class="navbar-container">
			<a href="#" class="logo">Property Management</a>
			<ul class="nav-links">
				<li><a href="/">Home</a></li>
				<li><a href="/property/PropertyPage">Properties</a></li>
				<li><a href="/aboutUs">About Us</a></li>
				<li><a href="/contact">Contact</a></li>
						   	
				
			<%
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			if (loggedInUser != null) {
				String roleDashboard = "";
				int roleId = loggedInUser.getRole().getRoleId();
				if (roleId == 1) {
					roleDashboard = "landlord_dashboard";
				} else if (roleId == 2) {
					roleDashboard = "manager_dashboard";
				} else if (roleId == 3) {
					roleDashboard = "tenant_dashboard";
				}
			%>
				<li class="dropdown">
					<a href="#" class="dropbtn"><%= loggedInUser.getFirstName() %></a>
					<div class="dropdown-content">
						<a href="/user/dashboard">Dashboard</a>
						<a href="/user/viewProfile">View Profile</a>
						<a href="/user/logout">Logout</a>
					</div>
				</li>
			<%
			} else {
			%>
				<li><a href="/user/openLoginPage" class="login-btn">Login</a></li>
			<%
			}
			%>
				
			</ul>
		</div>
	</nav>

	<header>
		<h2>Property Details</h2>
	</header>

	<div class="content">
		<div class="my-property-details">
			<%
			Property property = (Property) request.getAttribute("property");
			if (property != null) {
			%>

			<img
				src="<%=(property.getpropertyImage() != null && property.getpropertyImage().length > 0)
		? "data:image/jpeg;base64," + java.util.Base64.getEncoder().encodeToString(property.getpropertyImage())
		: "/images/default-image.png"%>"
				alt="<%=property.getTitle() != null ? property.getTitle() : "Image"%>" />

			<div class="my-property-info">
				<p>
					<strong>Title:</strong>
					<%=property.getTitle()%></p>
				<p>
					<strong>Description:</strong>
					<%=property.getDescription()%></p>
				<p>
					<strong>Location:</strong>
					<%=property.getLocation()%></p>
				<p>
					<strong>Price:</strong> $<%=property.getPrice()%></p>
				<p>
					<strong>Facilities:</strong>
				</p>
				<ul class="my-facility-list">
					<li class="facility-item"><span class="facility-icon">
							<%=property.isSwimmingPool() ? "✔" : "✖"%>
					</span> Swimming Pool</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isGym() ? "✔" : "✖"%>
					</span> Gym</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isParking() ? "✔" : "✖"%>
					</span> Parking</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isGarden() ? "✔" : "✖"%>
					</span> Garden</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isAirConditioning() ? "✔" : "✖"%>
					</span> Air Conditioning</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isElevator() ? "✔" : "✖"%>
					</span> Elevator</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isSecuritySystem() ? "✔" : "✖"%>
					</span> Security System</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isInternet() ? "✔" : "✖"%>
					</span> Internet</li>
					<li class="facility-item"><span class="facility-icon">
							<%=property.isFurnished() ? "✔" : "✖"%>
					</span> Furnished</li>
				</ul>
			</div>
			<%
			} else {
			%>
			<p>No property details available.</p>
			<%
			}
			%>

			<a href="/property/PropertyPage" class="btn-back">Back</a>
		</div>
	</div>

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
