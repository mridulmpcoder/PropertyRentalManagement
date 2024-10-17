<%@page import="property_management.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>User Profile</title>
<link href="../css/styles.css" rel="stylesheet" />
</head>
<body>

	<h1>User Profile</h1>
	<table>
		<tr>
			<td>First Name:</td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Email ID:</td>
			<td>${user.emailId}</td>
		</tr>
		<tr>
			<td>Mobile No:</td>
			<td>${user.mobileNo}</td>
		</tr>
		<tr>
			<td>Date of Birth:</td>
			<td>${user.dateOfBirth}</td>
		</tr>
		<tr>
			<td>Username:</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>${user.status}</td>
		</tr>
		<tr>
			<td>Profile Image:</td>
			<td>
				<%
				String profileImage = (String) session.getAttribute("profileImage");
				%>
				<%
				if (profileImage != null && !profileImage.isEmpty()) {
				%> <img
				src="data:image/jpeg;base64,<%=profileImage%>" alt="Profile Image" />
				<%
				} else {
				%>
				<p>No Profile Image</p> <%}%>
			</td>
		</tr>
		<tr>
			<td>ID Proof:</td>
			<td>
				<%
				String idProof = (String) session.getAttribute("idProof");
				%>
				<%
				if (idProof != null && !idProof.isEmpty()) {
				%> <img
				src="data:image/jpeg;base64,<%=idProof%>" alt="Id Proof" />
				<%
				} else {
				%>
				<p>No ID Proof</p> <%}%>
			</td>
		</tr>
	</table>
	<a href="/user/update?userId=${user.userId}">
		<button>Edit Profile</button>
	</a>


</body>
</html>

