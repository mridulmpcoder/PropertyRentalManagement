<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="property_management.app.controller.ManagerController"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Managers</title>
</head>
<body>
<h1>Manage Managers</h1>

<c:if test="${not empty message}">
    <div style="color: green;">
        ${message}
    </div>
</c:if>

<h2>Actions</h2>
<div>
    <form action="approveRejectManagers" method="GET">
        <button type="submit">Approve/Reject Managers</button>
    </form>
    <form action="assign_managers" method="GET">
        <button type="submit">Assign Managers</button>
    </form>
</div>

<h2>Managers List</h2>
<table border="1">
    <tr>
        <th>Manager ID</th>
        <th>Resume</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="manager" items="${managers}">
        <tr>
            <td>${manager.managerId}</td>
            <td>${manager.resume}</td>
            <td>${manager.approved ? "Approved" : "Pending"}</td>
            <td>
                <c:if test="${!manager.approved}">
                    <form action="approveManager" method="POST" style="display:inline;">
                        <input type="hidden" name="managerId" value="${manager.managerId}"/>
                        <button type="submit">Approve</button>
                    </form>
                    <form action="rejectManager" method="POST" style="display:inline;">
                        <input type="hidden" name="managerId" value="${manager.managerId}"/>
                        <button type="submit">Reject</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Managers</title>
</head>
<body>
    <h1>Manage Managers</h1>
    <div>
        <form action="${pageContext.request.contextPath}/approveRejectManagers" method="GET">
            <button type="submit">Approve/Reject Managers</button>
        </form>
        <form action="${pageContext.request.contextPath}/assignManagers" method="GET">
            <button type="submit">Assign Managers</button>
        </form>
    </div>
</body>
</html>
