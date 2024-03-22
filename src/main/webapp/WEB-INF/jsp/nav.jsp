<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<style>
  body {
    margin: 0;
    padding: 0;
    height: 100vh;
    display: flex;
    flex-direction: column;
  }
  .content {
    flex: 1;
  }
  .footer {
    background-color: #343a40;
    color: #fff;
    text-align: center;
    padding: 20px 0;
    width: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
  }
    
    

</style>


</head>
<body>

    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
              <a class="navbar-brand" href="/products">My Website</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                  <div>
                  <ul class="navbar-nav ms-auto">
                  <c:forEach var="authority" items="${pageContext.request.userPrincipal.authorities}">
                    <c:if test="${authority.authority eq 'admin'}">
                      <li class="nav-item">
                        <a class="nav-link" href="/users">User management form</a>
                      </li>
                    </c:if>
                  </c:forEach>
                  </ul>
                </div>
                <ul class="navbar-nav ms-auto">
                      <c:if test="${pageContext.request.userPrincipal.name != null}"> 
                          <li class="nav-item" ><a href="#" class="nav-link">${pageContext.request.userPrincipal.name }</a></li>
                          <li class="nav-item"><a href="/logout" class="nav-link">logout</a></li>
                      </c:if>
                </ul>
              </div>
            </div>
          </nav>
    </header>
    <main class="content">
   

