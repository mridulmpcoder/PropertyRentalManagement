<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Tenant</title>
</head>
<body>
    <h1>Delete Tenant</h1>

    <form action="deleteTenants" method="post">
        <label for="tenantId">Tenant ID:</label>
        <input type="text" id="tenantId" name="tenantId" required><br><br>
        <input type="submit" value="Delete Tenant">
    </form>

	<a href="manageTenants" class="button">
	<button type="button">Back To Manage Tenants</button></a>

    
</body>
</html>
