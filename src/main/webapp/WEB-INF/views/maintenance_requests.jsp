<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maintenance Requests</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 
<div class="container">
    <h2>Maintenance Requests</h2>
 
    <table>
        <tr>
            <th>Request ID</th>
            <th>Tenant Name</th>
            <th>Issue</th>
            <th>Status</th>
        </tr>
        <tr>
            <td>001</td>
            <td>John Doe</td>
            <td>Leaky faucet</td>
            <td>Pending</td>
            <!--<td>
                <button onclick="assignTechnician()">Assign Technician</button>
                <button onclick="addTechnician()">Add Technician</button>
            </td>-->
        </tr>
    </table>
 
    
</div>
<a href="/user/assignTechnician" class="button">
<button class="btn-primary">Assign Technician</button></a>

<a href="/user/addTechnician" class="button">
<button class="btn-primary">Add Technician</button></a>


<a href="/user/openLandlordDashboard" class="button">
<button class="btn-secondary">Back to DashBoard</button></a>

<!-- 
<script>
    function assignTechnician() {
        window.location.href = 'assign_technician.jsp';  // Redirect to Assign Technician page
    }
 
    function addTechnician() {
        window.location.href = 'add_technician.jsp';  // Redirect to Add Technician page
    }
 
    function redirectToDashboard() {
        window.location.href = 'manager_dashboard.jsp';  // Redirect to Manager Dashboard
    }
</script>-->
 
</body>
</html>
