<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .register-container {
            margin-top: 100px;
        }
        .register-form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            padding: 30px;
        }
        .register-heading {
            text-align: center;
            color: #007bff;
            font-weight: bold;
        }
        .register-form .form-group label {
            font-weight: bold;
        }
        .register-form .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
        }
        .register-form .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container register-container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="register-form">
                    <h2 class="register-heading mb-4">Register</h2>
                    <form action="/register" method="post" modelatrribute="user"  >
                        <div class="form-group">
                            <label for="username">name</label>
                            <input type="text" class="form-control" id="username" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                        </div>
                        <c:if test="${not empty error}">
                            <div style="color: red;">${error}</div>
                        </c:if>
						<div class="form-group">
                            <span>For sign in <a href="/login">click here</a></span>
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS (Optional, for certain Bootstrap components that require JavaScript) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

