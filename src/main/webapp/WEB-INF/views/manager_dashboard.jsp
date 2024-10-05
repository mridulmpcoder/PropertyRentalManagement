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

    <!-- Sidebar -->
    

    <!-- Header -->
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
                <a href="#">Manage Tenants</a>
            </div>

            <div class="btn-card requests">
                <h3>Manage Requests</h3>
                <a href="#">Manage Requests</a>
            </div>

            <div class="btn-card payments">
                <h3>Manage Payments</h3>
                <a href="/user/payment_management">Manage Payments</a>
            </div>

            <div class="btn-card profile">
                <h3>Profile & Settings</h3>
                <a href="#">Profile</a>
            </div>


        </div>
    </div>

</body>
</html>
