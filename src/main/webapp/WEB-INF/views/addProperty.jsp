<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


	<form action="/property/addProperty" method="post"
		enctype="multipart/form-data">

		<input type="text" name="title" placeholder="Enter Title of Property" /><br />
		<input type="text" name="description" placeholder="Enter Description" /><br />
		<input type="text" name="location" placeholder="Enter Location" /><br />
		<input type="text" name="type" placeholder="Property Type" /><br />
		<input type="text" name="price" placeholder="Price" /><br /> 
		<input type="file" name="propertyImage" accept=".jpg, .jpeg, .png, .pdf" multiple required /> 
		
		<label for="swimmingPool">Swimming Pool:</label>
        <input type="checkbox" name="swimmingPool" value="true" />
        
        <label for="gym">Gym:</label>
        <input type="checkbox" name="gym" value="true" />
        
        <label for="parking">Parking:</label>
        <input type="checkbox" name="parking" value="true" />		
		
		<label for="garden">Garden:</label>
        <input type="checkbox" name="garden" value="true" />
		
		<label for="airConditioning">Air Conditioning:</label>    
        <input type="checkbox" name="airConditioning" value="true" />
        
        <label for="elevator">Elevator:</label>
        <input type="checkbox" name="elevator" value="true" />
        
        <label for="securitySystem">Security System:</label>
        <input type="checkbox" name="securitySystem" value="true" />
        
        <label for="internet">Internet:</label>
        <input type="checkbox" name="internet" value="true" />
		
		<label for="furnished">Furnished:</label>
        <input type="checkbox" name="furnished" value="true" />
        
		<input type="submit" value="Submit" />

		<%@include file="./message.jsp"%>
	</form>
</body>
</html>