<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

 
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Payment Management</title> 
    <style> 
        /* Global Styles */ 
        body { 
            font-family: Arial, sans-serif; 
            margin: 0; 
            padding: 0; 
            background: linear-gradient(135deg, #a18cd1 0%, #fbc2eb 100%); 
            height: 100vh; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
        } 
 
        /* Container Styles */ 
        .container { 
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent background */ 
            padding: 30px; 
            border-radius: 10px; 
            width: 80%; 
            max-width: 900px; 
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Add shadow */ 
            text-align: center; 
        } 
 
        /* Header Styles */ 
        .header { 
            background-color: #6a1b9a; 
            color: white; 
            padding: 20px; 
            text-align: center; 
            border-radius: 10px; 
            margin-bottom: 20px; 
        } 
 
        /* Section Styles */ 
        .section { 
            margin-bottom: 20px; 
        } 
 
        .section h2 { 
            margin-bottom: 10px; 
        } 
 
        /* Button Styles */ 
        .btn { 
            display: inline-block; 
            padding: 10px 30px; 
            background-color: #6a1b9a; 
            color: white; 
            text-decoration: none; 
            border-radius: 5px; 
            transition: background-color 0.3s; 
            font-size: 18px; 
            margin: 5px; 
        } 
 
        .btn:hover { 
            background-color: #7b1fa2; 
        } 
 
        /* Back Button Style */ 
        .btn-back { 
            background-color: #4CAF50; 
        } 
 
        .btn-back:hover { 
            background-color: #45a049; 
        } 
 
        /* Table Styles */ 
        table { 
            width: 100%; 
            border-collapse: collapse; 
            margin-bottom: 20px; 
        } 
 
        table, th, td { 
            border: 1px solid #ddd; 
        } 
 
        th, td { 
            padding: 12px; 
            text-align: left; 
        } 
 
        th { 
            background-color: #6a1b9a; 
            color: white; 
        } 
    </style> 
</head> 
<body> 
 
<div class="container"> 
    <div class="header"> 
        <h1>Payment Management</h1> 
    </div> 
 
    <!-- View Payment Status Section --> 
    <div class="section"> 
        <h2>View Payment Status</h2> 
        <table> 
            <tr> 
                <th>Tenant Name</th> 
                <th>Payment Status</th> 
                <th>Amount Due</th> 
                <th>Due Date</th> 
            </tr> 
            <c:forEach var="payment" items="${payments}"> 
                <tr> 
                    <td>${payment.tenantName}</td> 
                    <td>${payment.paymentStatus}</td> 
                    <td>${payment.amountDue}</td> 
                    <td>${payment.dueDate}</td> 
                </tr> 
            </c:forEach> 
        </table> 
    </div> 
 
    <!-- Generate Invoice Section --> 
    <div class="section"> 
        <h2>Generate Invoice</h2> 
        <a href="#" class="btn">Generate</a> 
    </div> 
 
    <!-- Back to Dashboard Button --> 
    <div class="section"> 
        <a href="/user/manager_dashboard" class="btn btn-back">Back to Dashboard</a> 
    </div> 
</div> 
 
</body> 
</html>