<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Property Management</title>
<!-- Linking the CSS file -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
	<div class="container">
		<header>
			<h1>Property Management</h1>
			<nav>
				<ul>
					<li><a href="/landlord/openLandlordDashboard">Dashboard</a></li>
					<li><a href="/property/openAddProperty">Add New Property</a></li>
					<li><a href="/user/logout">Logout</a></li>
				</ul>
			</nav>
		</header>





		<section class="property-list">
            <h2>Your Properties</h2>
            <table>
                <thead>
                    <tr>
                        <th>Property Name</th>
                        <th>Category</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="property" items="${propertyList}">
                        <tr>
                            <td>${property.name}</td>
                            <td>${property.category}</td>
                            <td>${property.status}</td>
                            <td>
                                <a href="/property/viewProperties" class="btn">Edit</a>
                                <a href="${pageContext.request.contextPath}/deleteProperty/${property.id}" class="btn delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>

		<footer>
			<p>&copy; 2024 Property Rental Management System. All rights
				reserved.</p>
		</footer>
	</div>
</body>
</html>
