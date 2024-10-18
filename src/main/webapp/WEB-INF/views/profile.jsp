<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>User Profile</title>
    <link href="../css/styles.css" rel="stylesheet"/>
</head>
<body>
    <h1>User Profile</h1>

    <form:form method="POST" action="/user/updateProfile" modelAttribute="user" enctype="multipart/form-data">
        <table>
        	<form:hidden path="userId" />
            <tr>
                <td>First Name:</td>
                <td>
                    <form:input path="firstName" />
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                    <form:input path="lastName" />
                </td>
            </tr>
            <tr>
                <td>Email ID:</td>
                <td>
                    <form:input path="emailId" />
                </td>
            </tr>
            <tr>
                <td>Mobile No:</td>
                <td>
                    <form:input path="mobileNo" />
                </td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td>
                    <form:input path="dateOfBirth" type="date" />
                </td>
            </tr>
            <tr>
                <td>Profile Image:</td>
                <td>
                    <input type="file" name="profileImage" />
                </td>
            </tr>
        </table>
        <br>
        <button type="submit">Save Changes</button>
    </form:form>
    
    <%@include file="./message.jsp" %>

</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>User Profile</title>
    <link href="../css/styles.css" rel="stylesheet"/>
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
            <td>Profile Image:</td>
            <td>
                <c:if test="${not empty base64Image}">
                    <img src="data:image/jpeg;base64,${base64Image}" alt="Profile Image" width="100" height="100"/>
                </c:if>
                <c:if test="${empty base64Image}">
                    <p>No image uploaded</p>
                </c:if>
            </td>
        </tr>
    </table>
    <br>
    <form action="/user/updateProfile" method="POST">
        <button type="submit">Update Profile</button>
    </form>

</body>
</html>

