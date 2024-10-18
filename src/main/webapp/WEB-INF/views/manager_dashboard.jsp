<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manager Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <!-- Constant Navigation Bar (Header) -->
    <nav class="navbar">
        <div class="navbar-container">
            <a href="#" class="logo">Property Management</a>
            <ul class="nav-links">
                <li><a href="/">Home</a></li>
                <li><a href="/PropertyPage">Properties</a></li>
                <li><a href="/aboutUs">About Us</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/user/openLoginPage" class="login-btn">Login</a></li>
            </ul>
        </div>
    </nav>

    <!-- Header for Dashboard -->
    <div class="header">
        <h1>Welcome</h1>
        <a href="/" class="logout">Logout</a>
    </div>

    <!-- Dashboard Container -->
    <div class="dashboard-container">
        <div class="btn-container">
            <!-- Buttons for Manager Actions -->
            <div class="btn-card tenants">
                <h3>Manage Tenants</h3>
                <a href="/manager/tenantManagement">Manage Tenants</a>
            </div>

            <div class="btn-card requests">
                <h3>Manage Requests</h3>
                <a href="/manager/managerMaintenance">Manage Requests</a>
                
            </div>

            <div class="btn-card payments">
                <h3>Manage Payments</h3>
                <a href="/landlord/paymentManagement">Manage Payments</a>
            </div>

            <div class="btn-card profile">
                <h3>Profile & Settings</h3>
                <a href="/viewProfile">Profile</a>
            </div>
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
