<%@page import="property_management.app.entities.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            text-decoration: none;
            margin-right: 10px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #45a049;
        }

        .btn-back {
            background-color: #f44336;
        }

        .btn-back:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

<h2>Old Payment Details</h2>

<!-- Payment Details Table -->
<table>
    <thead>
        <tr>
            <th>Payment ID</th>
            <th>Tenant Name</th>
            <th>Property</th>
            <th>Amount</th>
            <th>Payment Method</th>
            <th>Payment Date</th>
        </tr>
    </thead>
    <tbody>
        <!-- Iterate over the payment list using JSP scriptlets -->
        <%
            List<Payment> paymentList = (List<Payment>) request.getAttribute("paymentList");
            if (paymentList != null && !paymentList.isEmpty()) {
                for (Payment payment : paymentList) {
        %>
                    <tr>
                        <td><%= payment.getPaymentId() %></td>
                        <td><%= payment.getTenantId() %></td>
                        <td><%= payment.getAmount() %></td>
                        <td><%= payment.getPaymentMethod() %></td>
                        <td><%= payment.getPaymentDate() %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="6">No payment records found.</td>
                </tr>
        <%
            }
        %>
    </tbody>
</table>

<!-- Buttons for make payment and back to dashboard -->
<a href="<%= request.getContextPath() %>/tenant/paymentPage" class="btn">Make Payment</a>
<a href="<%= request.getContextPath() %>/tenant/tenantDashboard" class="btn btn-back">Back to Dashboard</a>

</body>
</html>
