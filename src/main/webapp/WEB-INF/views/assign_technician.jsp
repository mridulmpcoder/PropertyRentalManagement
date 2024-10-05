<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign Technician</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 
<div class="container">
    <h2>Assign Technician</h2>
    <form id="assignTechnicianForm">
        <div>
            <label for="technician-name">Technician Name:</label>
            <select id="technician-name" name="technicianName" required>
                <option value="" disabled selected>Select Technician</option>
                <option value="technician1">Technician 1</option>
                <option value="technician2">Technician 2</option>
                <option value="technician3">Technician 3</option>
            </select>
        </div>
 
        <div>
            <label for="request-id">Request ID:</label>
            <input type="text" id="request-id" name="requestId" value="001" readonly>
        </div>
 
        <div>
            <label for="task-details">Task Details:</label>
            <textarea id="task-details" name="taskDetails" rows="4" placeholder="Provide additional task details"></textarea>
        </div>
 
        <div>
			
			
            <button type="submit">Assign Technician</button>
			<a href="/user/maintenanceRequests" class="button">
			<button type="button">Cancel</button></a>
        </div>
    </form>
</div>
 
<!--<script>
    function assignManager() {
        var selectedManager = document.getElementById("manager-select").value;
        alert("Manager " + selectedManager + " has been assigned successfully.");
    }
</script>-->
</body>
</html>
