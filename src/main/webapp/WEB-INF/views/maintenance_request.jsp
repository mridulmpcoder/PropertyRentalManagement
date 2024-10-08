<form action="/api/maintenance/submit" method="post" enctype="multipart/form-data" onsubmit="return handleSubmit(event)">
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

    <input type="hidden" name="tenantId" value="${tenantId}" />
   
    <label for="requestType">Request Type</label>
    <select id="requestType" name="requestType" required>
        <option value="Plumbing">Plumbing</option>
        <option value="Electrical">Electrical</option>
        <option value="Heating/Cooling">Heating/Cooling</option>
        <option value="Other">Other</option>
    </select>

    <label for="description">Description</label>
    <textarea id="description" name="description" rows="4" required></textarea>

    <label for="photo">Upload Photo (Optional)</label>
    <input type="file" id="photo" name="photo" accept="image/*">

    <button type="submit">Submit Request</button>
    <button type="button" onclick="window.location.href='/user/maintenanceRequest';">Back to Dashboard</button>
</form>

<script>
    function handleSubmit(event) {
        event.preventDefault(); // Prevents the default form submission
        
        // Here you can make the actual request using AJAX if needed
        const form = event.target;
        const formData = new FormData(form);

        fetch(form.action, {
            method: form.method,
            body: formData
        })
        .then(response => {
            if (response.ok) {
                alert('Request is submitted successfully!');
                window.location.reload(); // Reloads the page after submission
            } else {
                alert('Failed to submit the request. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('There was an error submitting the request.');
        });

        return false; // Prevents the form from submitting the traditional way
    }
</script>
