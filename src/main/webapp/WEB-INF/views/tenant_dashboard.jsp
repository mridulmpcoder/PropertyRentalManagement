<%@page import="property_management.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Tenant Dashboard">
<title>Tenant Dashboard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body
	style="background-image: url('/images/buildings-silhouette-cityscape-background-modern-architecture-urban-city-landscape-vector.jpg');">

	<!-- Constant Navigation Bar -->
	<%
	User user = (User) request.getAttribute("user");
	%>
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

	<!-- Dashboard Section -->
	<section class="dashboard-section">
		<div class="dashboard-container">

			<!-- View Property Card -->
			<div class="dashboard-card">
				<h2>View My Property</h2>
				<p>Check the details of the property you're currently renting.</p>
				<a href="/user/myProperty/1" class="btn-primary">View Property</a>
			</div>

			<!-- Manage Lease Card -->
			<div class="dashboard-card">
				<h2>Manage Lease</h2>
				<p>Access and review your lease agreement.</p>
				<a href="/viewLease" class="btn-primary">View Lease Agreement</a>
			</div>

			<!-- Payments & Invoices Card -->
			<div class="dashboard-card">
				<h2>Payments & Invoices</h2>
				<p>Make rental payments and review invoices.</p>
				<a href="/tenant/paymentPage" class="btn-primary">Make Payment</a>
			</div>

			<!-- Maintenance Requests Card -->
			<div class="dashboard-card">
				<h2>Request Maintenance</h2>
				<p>Submit a request for maintenance or repairs.</p>
				<a href="/tenant/maintenanceRequest" class="btn-primary">Request
					Maintenance</a>
			</div>

			<!-- Profile & Settings Card -->
			<div class="dashboard-card">
				<h2>Profile & Settings</h2>
				<p>View and update your profile information.</p>
				<form action="<%=request.getContextPath()%>/user/viewProfile"
					method="GET">
					<input type="hidden" name="user_id" value="<%=user.getUserId()%>" />
					<button type="submit">Profile</button>
				</form>
			</div>

			<!-- <div class="dashboard-card">
                <h2>Profile & Settings</h2>
                <p>View and update your profile information.</p>
                <a href="/profile" class="btn-primary">Profile</a>
            </div> -->

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