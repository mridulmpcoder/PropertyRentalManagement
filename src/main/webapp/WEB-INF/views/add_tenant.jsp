<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Tenant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="manager_dashboard.jsp">Dashboard</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Add Tenant</h1>
        <form action="add_tenant" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"><br><br>
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone"><br><br>
            <label for="lease-start">Lease Start:</label>
            <input type="date" id="lease-start" name="lease-start"><br><br>
            <label for="lease-end">Lease End:</label>
            <input type="date" id="lease-end" name="lease-end"><br><br>
            <button type="submit">Add Tenant</button>
           <!-- <button type="button" onclick="window.location.href='manage_tenants.jsp'">
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
