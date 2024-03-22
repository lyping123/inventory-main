
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .login-container {
            margin-top: 100px;
        }
        .login-form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            padding: 30px;
        }
        .login-heading {
            text-align: center;
            color: #007bff;
            font-weight: bold;
        }
        .login-form .form-group label {
            font-weight: bold;
        }
        .login-form .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
        }
        .login-form .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
    
    <div class="container login-container">
        <c:if test="${not empty sessionScope.successMessage}">
       
        <script>
            window.onload = function() {
                //let a=document.getElementById("text").innerText;
                showLoginSuccessMessage("${sessionScope.successMessage}");
            };
            </script>
            <% session.removeAttribute("successMessage"); %>   
        </c:if>

        <c:if test="${param.logout eq 'true'}">
            <script>
                window.onload = function() {
                    //let a=document.getElementById("text").innerText;
                    alert("logut success");
                };
                </script>
        </c:if>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="login-form">
                    <h2 class="login-heading mb-4">Login</h2>
                    <form action="/login" method="post" modelatrribute="user">
                        <div class="form-group">
                            <label for="username">email</label>
                            <input type="text" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <c:if test="${param.error eq 'true'}">
                            <p style="color: red;">Login failed. Please check your email and password.</p>
                        </c:if>
                        <div class="form-group">
                            <span class="" >Not yet register? <a href="/register">click here!</a></span>
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Login</button>
                       
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
  
        function showLoginSuccessMessage(message) {
            alert(message);
        }
      </script>
    <!-- Bootstrap JS (Optional, for certain Bootstrap components that require JavaScript) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
