<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Maintenance Request Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 50%;
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
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        select, textarea, input[type="file"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
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
        <h2>Maintenance Request Form</h2>
        <form action="submitRequest.jsp" method="post" enctype="multipart/form-data">
            <label for="requestType">Request Type</label>
            <select id="requestType" name="requestType" required>
                <option value="">Select a type</option>
                <option value="Plumbing">Plumbing</option>
                <option value="Electrical">Electrical</option>
                <option value="Heating/Cooling">Heating/Cooling</option>
                <option value="Other">Other</option>
            </select>

            <label for="description">Description</label>
            <textarea id="description" name="description" rows="4" placeholder="Describe the issue" required></textarea>

            <label for="photo">Upload Photo (Optional)</label>
            <input type="file" id="photo" name="photo" accept="image/*">

            <div style="display: flex; justify-content: space-between;">
                <button type="submit">Submit Request</button>
                <button type="button" class="btn-back" onclick="window.location.href='tenantDashboard.jsp';">Back to Dashboard</button>
            </div>
        </form>
    </div>
</body>
</html>
