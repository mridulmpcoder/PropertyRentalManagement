<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Tenants</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Manage Tenants</h1>

    <form action="addTenants" method="get">
        <button type="submit">Add Tenant</button>
    </form>
    <form action="deleteTenants" method="get">
        <button type="submit">Delete Tenant</button>
    </form>
    <form action="dashboard.jsp" method="get">
        <button type="submit">Back to Dashboard</button>
    </form>
</body>
</html>
