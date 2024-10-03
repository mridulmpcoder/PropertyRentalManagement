<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tenant Management</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 
<div class="container">
    <h2>Manage Tenants</h2>
    <table>
        <tr>
            <th>Tenant Name</th>
            <th>Lease Expiry</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>John Doe</td>
            <td>2025-12-31</td>
            <td><button onclick="viewTenantProfile()">View Profile</button></td>
        </tr>
        <!-- Add more rows as needed -->
    </table>
	<a href="/user/manageTenants" class="button">
    <button class="btn-primary">Manage Tenants</button></a>
    <button class="btn-secondary">Back to Dashboard</button>
</div>
 
<!--<script>
    function viewTenantProfile() {
        window.location.href = 'tenant_profile.jsp'; // Redirect to tenant profile
    }
 
    function manageTenants() {
        window.location.href = 'manage_tenants.jsp'; // Open Manage Tenants Page
    }
 
    function redirectToDashboard() {
        window.location.href = 'manager_dashboard.jsp';
    }
</script>-->
 
</body>
</html>
