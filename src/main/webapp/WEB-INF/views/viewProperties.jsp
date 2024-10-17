<%@page import="java.util.Base64"%>
<%@page import="property_management.app.entities.Property"%>
<%@page import="java.util.List"%>
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
<head>
<title>View Properties</title>
</head>
<body>


	<table border="1">
		<thead>
			<tr>
				<th>Title</th>
				<th>Type</th>
				<th>Price</th>
				<th>Amenities</th>
				<th>Image</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Property property : (List<Property>) request.getAttribute("properties")) {
			%>
			<tr>
				<td><%=property.getTitle()%></td>
				<td><%=property.getType()%></td>
				<td><%=property.getPrice()%></td>
				<td>Swimming Pool: <%=property.isSwimmingPool() ? "Yes" : "No"%><br />
					Gym: <%=property.isGym() ? "Yes" : "No"%><br /> Garden: <%=property.isGarden() ? "Yes" : "No"%><br />
					Parking: <%=property.isParking() ? "Yes" : "No"%><br /> Air
					Conditioning: <%=property.isAirConditioning() ? "Yes" : "No"%><br />
					Elevator: <%=property.isElevator() ? "Yes" : "No"%><br />
					Security System: <%=property.isSecuritySystem() ? "Yes" : "No"%><br />
					Internet: <%=property.isInternet() ? "Yes" : "No"%><br />
					Furnished: <%=property.isFurnished() ? "Yes" : "No"%>
				</td>
				<td><img
					src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(property.getImage())%>"
					width="100" height="100" /></td>
				<td><a
					href="<%=request.getContextPath()%>/property/propertyDetails/<%=property.getPropertyId()%>">View
						Details</a> 
						<a href="<%=request.getContextPath()%>/property/openUpdateProperty/<%=property.getPropertyId()%>">Update</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<form action="addProperty" method="get">
		<input type="submit" value="Add New Property">
	</form>




	<%-- <h2>Properties List</h2>

	<table border="1">
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Type</th>
			<th>Price</th>
			<th>Image</th>
		</tr>
		<%
		List<Property> properties = (List<Property>) request.getAttribute("properties");
		for (Property property : properties) {
		%>
		<tr>
			<td><%=property.getTitle()%></td>
			<td><%=property.getDescription()%></td>
			<td><%=property.getType()%></td>
			<td><%=property.getPrice()%></td>
			<td><img
				src="data:image/jpeg;base64,<%=property.getImage() != null ? Base64.getEncoder().encodeToString(property.getImage()) : ""%>"
				alt="Property Image" width="100" height="100" /></td>
		</tr>
		<%
		}
		%>
	</table> --%>



</body>
</html>
