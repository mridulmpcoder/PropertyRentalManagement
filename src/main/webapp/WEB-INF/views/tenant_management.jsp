<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tenant Management</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Tenant Management</h1>
    <form action="viewTenants" method="get">
        <button type="submit">View All Tenants</button>
    </form>
    <form action="manageTenants" method="get">
        <button type="submit">Manage Tenants</button>
    </form>
    <form action="dashboard.jsp" method="get">
        <button type="submit">Back to Dashboard</button>
    </form>
</body>
</html>




