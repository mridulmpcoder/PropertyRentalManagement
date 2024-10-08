<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Add Tenant</title>
</head>
<body>
    <h1>Add Tenant</h1>

    <form action="addTenant" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>
        
        <label for="leaseStartDate">Lease Start Date:</label>
        <input type="date" id="leaseStartDate" name="leaseStartDate" required><br><br>

        <label for="leaseEndDate">Lease End Date:</label>
        <input type="date" id="leaseEndDate" name="leaseEndDate" required><br><br>

        <input type="submit" value="Add Tenant">
    </form>

    <!--<form action="dashboard.jsp" method="get">
        <button type="submit">Back to Dashboard</button>
    </form-->

	<a href="manageTenants" class="button">
	<button type="button">Back To Manage Tenants</button></a>
	
</body>
</html>
