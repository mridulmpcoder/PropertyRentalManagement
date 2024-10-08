<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 60%;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
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
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            width: 48%;
            padding: 10px;
            border: none;
            background-color: #5cb85c;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4cae4c;
        }
        .btn-back {
            background-color: #d9534f;
            float: right;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Tenant Payment Page</h2>

        <!-- Payment History Section -->
        <h3>Past Payment History</h3>
        <table>
            <thead>
                <tr>
                    <th>Payment Date</th>
                    <th>Amount</th>
                    <th>Payment Method</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="payment" items="${payments}">
                    <tr>
                        <td>${payment.paymentDate}</td>
                        <td>${payment.amount}</td>
                        <td>${payment.paymentMethod}</td>
                        <td>${payment.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Action Buttons -->
        <div style="display: flex; justify-content: space-between;">
            <button type="button" onclick="window.location.href='paymentGateway.jsp';">Make Payment</button>
            <button type="button" class="btn-back" onclick="window.location.href='tenantDashboard.jsp';">Back to Dashboard</button>
        </div>
    </div>
</body>
</html>
