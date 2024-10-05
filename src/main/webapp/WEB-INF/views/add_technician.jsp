<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Technician</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 
<div class="container">
    <h2>Add New Technician</h2>
    <form id="addTechnicianForm" action="addTechnician" method="post">
        <div>
            <label for="technician-name">Technician Name:</label>
            <input type="text" id="technician-name" name="technicianName" placeholder="Enter technician name" required>
        </div>
 
        <div>
            <label for="technician-email">Email:</label>
            <input type="email" id="technician-email" name="technicianEmail" placeholder="Enter technician email" required>
        </div>
 
        <div>
            <label for="technician-phone">Phone Number:</label>
            <input type="tel" id="technician-phone" name="technicianPhone" placeholder="Enter phone number" required>
        </div>
 
        <div>
            <button type="submit">Add Technician</button>
           
			<a href="/user/maintenanceRequests" class="button">
			<button type="button">Cancel</button></a>
						
        </div>
    </form>
</div>
 
<!--<script>
    function backToRequests() {
        window.location.href = 'maintenance_requests.jsp';  // Redirect back to Maintenance Requests page
    }
</script>-->
 
</body>
</html>
