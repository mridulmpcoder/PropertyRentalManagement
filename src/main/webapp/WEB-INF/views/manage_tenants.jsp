<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Tenants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="manager-dashboard.jsp">Dashboard</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Add Tenants</h1>
		<a href="/user/addTenants" class="button">
		<button class="btn-primary">Add Tenants</button></a>
		<a href="/user/deleteTenants" class="button">
		<button class="btn-primary">Delete Tenants</button></a>
    </main>
    <footer>
        <p>© 2024 Property Rental Management System</p>
    </footer>
</body>
</html>
