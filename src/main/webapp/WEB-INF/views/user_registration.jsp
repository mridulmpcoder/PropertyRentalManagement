<%@page import="property_management.app.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Page</title>
<style>
form, p {
	text-align: center;
}

input {
	margin-bottom: 10px
}
</style>
</head>
<body>

	

	

	<form action="register" method="post" enctype="multipart/form-data">
		<input type="text" name="firstName" placeholder="Enter First Name" /><br />
		<input type="text" name="lastName" placeholder="Enter Last Name" /><br />
		<input type="text" name="emailId" placeholder="Enter Email Id" /><br />
		<input type="text" name="mobileNo" placeholder="Enter Mobile No" /><br />
		<input type="date" name="dateOfBirth" /><br /> 
		<input type="text" name="username" placeholder="Enter username" /><br /> 
		<input type="password" name="password" placeholder="Enter password" /><br />

		<input type="file" name="profileImage" accept=".jpg, .jpeg, .png, .pdf" required>

	

		<input type="submit" value="Submit" />
		
		<p>Not Registered? Click <a href = "/user/register">here</a> to register</p>
		
		<%@include file="message.jsp" %>
	</form>

</body>
</html>