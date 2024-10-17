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


	 <h1>Add New Property</h1>
    <form action="addProperty" method="post" enctype="multipart/form-data">
        <label>Title:</label>
        <input type="text" name="title" required/><br/>
        
        <label>Description:</label>
        <textarea name="description" required></textarea><br/>
        
        <label>Location:</label>
        <input type="text" name="location" required/><br/>
        
       <!--  <label>Type:</label>
        <select name="type" required>
            <option value="Society">Society</option>
            <option value="Villas">Villas</option>
            <option value="Shop">Shop</option>
            <option value="Independent House">Independent House</option>
        </select><br/> -->

        <label>Status:</label>
        <select name="status" required>
            <option value="Vacant">Vacant</option>
            <option value="Occupied">Occupied</option>
            <option value="Under Maintenance">Under Maintenance</option>
        </select><br/>
        
        <label>Amenities:</label><br/>
        <input type="checkbox" name="swimmingPool"/> Swimming Pool<br/>
        <input type="checkbox" name="gym"/> Gym<br/>
        <input type="checkbox" name="garden"/> Garden<br/>
        <input type="checkbox" name="parking"/> Parking<br/>
        <input type="checkbox" name="airConditioning"/> Air Conditioning<br/>
        <input type="checkbox" name="elevator"/> Elevator<br/>
        <input type="checkbox" name="securitySystem"/> Security System<br/>
        <input type="checkbox" name="internet"/> Internet<br/>
        <input type="checkbox" name="furnished"/> Furnished<br/>
        
        <label>Price:</label>
        <input type="text" name="price" required/><br/>
        
        <input type="file" name="profileImage" accept=".jpg, .jpeg, .png, .pdf" required>
        
        <input type="submit" value="Add Property"/>

		<%@include file="./message.jsp"%>
	</form>
</body>
</html>