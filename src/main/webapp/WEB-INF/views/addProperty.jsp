<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>


	<h2>Add Property</h2>




	<form:form method="POST"
		action="${pageContext.request.contextPath}/property/addProperty"
		modelAttribute="property" enctype="multipart/form-data">

		<table>
			<tr>
				<td>Property Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Property Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Property Type:</td>
				<td><form:select path="type_id">
						<form:option value="1">Apartment</form:option>
						<form:option value="2">Shop</form:option>
						<form:option value="3">Villa</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" type="number" step="0.01" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><form:input path="status" /></td>
			</tr>
			<tr>
				<td>Flat Number:</td>
				<td><form:input path="flatNo" /></td>
			</tr>
			<tr>
				<td>Floor:</td>
				<td><form:input path="floor" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td><form:input path="zip_code" /></td>
			</tr>
			<tr>
				<td>Latitude:</td>
				<td><form:input path="latitude" type="number" step="0.0000001" /></td>
			</tr>
			<tr>
				<td>Longitude:</td>
				<td><form:input path="longitude" type="number" step="0.0000001" /></td>
			</tr>

			<!-- Facilities -->
			<tr>
				<td>Swimming Pool:</td>
				<td><form:checkbox path="swimmingPool" /></td>
			</tr>
			<tr>
				<td>Gym:</td>
				<td><form:checkbox path="gym" /></td>
			</tr>
			<tr>
				<td>Parking:</td>
				<td><form:checkbox path="parking" /></td>
			</tr>
			<tr>
				<td>Garden:</td>
				<td><form:checkbox path="garden" /></td>
			</tr>
			<tr>
				<td>Air Conditioning:</td>
				<td><form:checkbox path="airConditioning" /></td>
			</tr>
			<tr>
				<td>Elevator:</td>
				<td><form:checkbox path="elevator" /></td>
			</tr>
			<tr>
				<td>Security System:</td>
				<td><form:checkbox path="securitySystem" /></td>
			</tr>
			<tr>
				<td>Internet:</td>
				<td><form:checkbox path="internet" /></td>
			</tr>
			<tr>
				<td>Furnished:</td>
				<td><form:checkbox path="furnished" /></td>
			</tr>

			<!-- Image Upload -->
			<tr>
				<td>Property Image:</td>
				<td><input type="file" name="image" id="image" /></td>

			</tr>

		</table>

		<button type="submit">Add Property</button>

	</form:form>
</body>
</html>