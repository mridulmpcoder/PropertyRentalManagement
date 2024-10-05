<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Tenant</title>
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
        <h1>Delete Tenant</h1>
        <form action="delete_tenant" method="post">
            <label for="tenant-id">Tenant ID:</label>
            <input type="number" id="tenant-id" name="tenant-id"><br><br>
            <button type="submit">Delete Tenant</button>
            <!--<button type="button" onclick="window.location.href='manage_tenants.jsp'">
				Back to Manage Tenants</button>-->
				<a href="/user/manageTenants" class="button">
				<button type="button">Manage Tenants</button></a>
        </form>
    </main>
    <footer>
        <p>© 2024 Property Rental Management System</p>
    </footer>
</body>
</html>
