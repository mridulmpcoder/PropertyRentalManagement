<%@page import="property_management.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Update Profile</title>
    <link href="../css/styles.css" rel="stylesheet" />
</head>
<body>
<h1>Profile</h1>

	<form:form method="POST" action="/user/update"
		modelAttribute="user" enctype="multipart/form-data">
		<table>
			<form:hidden path="userId" />
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email ID:</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td>Mobile No:</td>
				<td><form:input path="mobileNo" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input path="dateOfBirth" type="date" /></td>
			</tr>
			<tr>
			<td>Username:</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Status:</td>
			<td><form:input path="status" /></td>
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
				src="data:image/jpeg;base64,<%=profileImage%>" alt="Profile Image" id="profileImagePreview"/>
				<%
				} else {
				%>
				<p>No Profile Image</p> <%}%>
				<input type="file" name="profileImage" id="profileImage" onchange="previewImage(event)">
			</td>		
			</tr>
				<tr>
			<td>Id Proof:</td>
			<td>
				<%
				String idProof = (String) session.getAttribute("idProof");
				%>
				<%
				if (idProof != null && !idProof.isEmpty()) {
				%> <img
				src="data:image/jpeg;base64,<%=idProof%>" alt="ID Proof" id="idProofPreview"/>
				<%
				} else {
				%>
				<p>No ID Proof</p> <%}%>
				<input type="file" name="idProof" id="idProof" onchange="idProofPreview(event)">
			</td>		
			</tr>
		</table>
		<br>
		<button type="submit">Save Changes</button>
	</form:form>
	
	 <script>
        // JavaScript to preview the image
        function previewImage(event) {
            var reader = new FileReader();
            reader.onload = function(){
                var output = document.getElementById('profileImagePreview');
                output.src = reader.result;
            }
            reader.readAsDataURL(event.target.files[0]);
        }
        
        function idProofPreview(event) {
            var reader = new FileReader();
            reader.onload = function(){
                var output = document.getElementById('idProofPreview');
                output.src = reader.result;
            }
            reader.readAsDataURL(event.target.files[0]);
        }
    </script>



<%-- 
<div class="container">
        <h2>Edit Profile</h2>
 
        <% String profileImage = (String) request.getAttribute("profileImage"); %>
        <% if (profileImage != null) { %>
            <img src="data:image/jpeg;base64,<%= profileImage %>" alt="Profile Image" />
        <% } else { %>
            <p>No Profile Image</p>
        <% } %>
 
        <form action="${pageContext.request.contextPath}/user/update" method="post" enctype="multipart/form-data">
            <label for="username"></label>
            <input id="username" type="hidden" name="username" value="${user.username}" required />
 
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${user.firstName}" required />
 
            <label for="mobileNo">Mobile No:</label>
            <input type="text" id="mobileNo" name="mobileNo" value="${user.mobileNo}" required />
 
            <label for="dateOfBirth">DOB:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" value="${user.dateOfBirth}" required />
 
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${user.lastName}" required />
 
            <label for="emailId">Email:</label>
            <input type="email" id="emailId" name="emailId" value="${user.emailId}" required />
 
            <label for="profileImage">Profile Image:</label>
            <input type="file" id="profileImage" name="profileImage" />
 
            <button type="submit">Update Profile</button>
        </form>
    </div>
     --%>
</body>
</html>
