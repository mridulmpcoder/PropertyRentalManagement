<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>User Login Page</title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	</head>
<body>

	<form action="/user/login" method="post">
		<input type="text" name="username" placeholder="Enter username" /><br /> 
		<input type="password" name="password" placeholder="Enter password" /><br />
		<input type="submit" value="Submit" />
		<p>Not Registered? Click <a href = "/user/openRegistrationPage">here</a> to register</p>
	</form>
	
	
	
	<%@include file="message.jsp" %>
</body>
</html>