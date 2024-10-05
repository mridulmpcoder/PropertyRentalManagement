<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landlord Dashboard</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <div class="container">
        <h1>Landlord Dashboard</h1>

        <div class="button-container">

            <a href="/user/openPropertyManagement" class="button">Manage Properties</a>
            <a href="/user/assignManagers" class="button">Assign Managers</a>
            <a href="/user/openReports" class="button">View Reports</a>
            <a href="/user/tenantManagement" class="button">Manage Tenants</a>
            <a href="/user/maintenanceRequests" class="button">View Maintenance Requests</a>
            <a href="${pageContext.request.contextPath}/rent-payment-overview" class="button">Rent Payment Overview</a>
            <a href="${pageContext.request.contextPath}/profile" class="button">Profile & Settings</a>
            <a href="/landlord/openPropertyManagement" class="button">Manage Properties</a>
            <a href="/landlord/managerAssingment" class="button">Assign Managers</a>
            <a href="/landlord/openReports" class="button">View Reports</a>
            <a href="/landlord/manageTenants" class="button">Manage Tenants</a>
            <a href="/landlord/managerMaintenance" class="button">View Maintenance Requests</a>
            <a href="/landlord/paymentManagement" class="button">Rent Payment Overview</a>
            <a href="/user/viewProfile" class="button">Profile & Settings</a>
			<a href="/user/logout">Logout</a>
        </div>
    </div>

</body>
</html>
