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
            <a href="${pageContext.request.contextPath}/assign-managers" class="button">Assign Managers</a>
            <a href="/user/openReports" class="button">View Reports</a>
            <a href="${pageContext.request.contextPath}/manage-tenants" class="button">Manage Tenants</a>
            <a href="${pageContext.request.contextPath}/maintenance-requests" class="button">View Maintenance Requests</a>
            <a href="${pageContext.request.contextPath}/rent-payment-overview" class="button">Rent Payment Overview</a>
            <a href="${pageContext.request.contextPath}/profile" class="button">Profile & Settings</a>
			<a href="/user/logout">Logout</a>
        </div>
    </div>

</body>
</html>
