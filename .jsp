<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="dbconne.jsp" %>
<%@ include file="functions.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Medicine</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Include other CSS files if needed -->
</head>
<body>
    <%@ include file="sidenav.html" %>
    <div class="container">
        <h1>Add New Medicine</h1>
        <!-- Form to add a new medicine -->
        <form action="add_medicine_action.jsp" method="post">
            <div class="form-group">
                <label for="medicineName">Medicine Name:</label>
                <input type="text" class="form-control" id="medicineName" name="medicineName" required>
            </div>
            <!-- Add more input fields for other details of the medicine -->
            <button type="submit" class="btn btn-primary">Add Medicine</button>
        </form>
    </div>
    <!-- Include Bootstrap and other JavaScript files if needed -->
</body>
</html>
