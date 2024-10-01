<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<style> form, p {text-align: center;} input {margin-bottom: 10px}</style>
</head>
<body>

	<form action="/user/login" method="post">
		<input type="text" name="username" /><br/>
		<input type="password" name="password" /><br/>
		<input type="submit" value="Submit" />
	</form>
	
	<p>Not Registered? Click <a href = "/user/openRegistrationPage">here</a> to register</p>
	
	<%@include file="message.jsp" %>
</body>












</html>