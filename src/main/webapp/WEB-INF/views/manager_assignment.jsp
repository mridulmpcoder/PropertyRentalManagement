<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manager Assignment</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 
<div class="container">
    <h2>Assign Manager</h2>
    <label for="manager-select">Select a Property Manager:</label>
    <select id="manager-select">
        <option value="manager1">Manager 1</option>
        <option value="manager2">Manager 2</option>
        <option value="manager3">Manager 3</option>
    </select>
    <button class="btn-primary" onclick="assignManager()">Assign</button>
   
	<a href="/user/openLandlordDashboard" class="button">
	<button class="btn-secondary">Back to DashBoard</button></a>
</div>
 
<script>
    function assignManager() {
        var selectedManager = document.getElementById("manager-select").value;
        alert("Manager " + selectedManager + " has been assigned successfully.");
    }
</script>
 
</body>
</html>
