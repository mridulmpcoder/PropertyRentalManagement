<%@page import="property_management.app.entities.User"%>
<%@page import="property_management.app.entities.Role"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>User Registration Page</title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	</head>
<body>
	
	<h2>Manager Registration</h2>

		<form action="managerRegister" method="post" enctype="multipart/form-data">
			<input type="text" name="firstName" placeholder="Enter First Name" /><br />
			<input type="text" name="lastName" placeholder="Enter Last Name" /><br />
			<input type="text" name="emailId" placeholder="Enter Email Id" /><br />
			<input type="text" name="mobileNo" placeholder="Enter Mobile No" /><br />
			<input type="date" name="dateOfBirth" /><br /> 
			<input type="text" name="username" placeholder="Enter username" /><br /> 
			<input type="password" name="password" placeholder="Enter password" /><br />

			<input type="file" name="profileImage" accept=".jpg, .jpeg, .png, .pdf" required>


			<input type="submit" value="Submit" />
			
			<p>Already Registered? Click <a href = "/user/openLoginPage">here</a> to login</p>
			<p>Want to register as Tenant? Click <a href = "/user/openTenantRegistrationPage">here</a></p>
			
			<%@include file="./message.jsp" %>
		</form>


</body>
</html>