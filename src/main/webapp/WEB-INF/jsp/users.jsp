<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/nav.jsp" %>

<div class="container" style="flex: 1;">

    <c:if test="${not empty sessionScope.successMessage}">
       
        <script>
            window.onload = function() {
                //let a=document.getElementById("text").innerText;
                showLoginSuccessMessage("${sessionScope.successMessage}");
            };
        </script>
        <% session.removeAttribute("successMessage"); %>   
    </c:if>
    <form action="/users" method="get">
        <div class="row">
        
            <h2 class="text-center mb-4">User Management Form</h2>
            <div class="col-md-3">
                <input type="text" name="searchvalue" class="form-control" >
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>


	<table class="mt-3 table table-bordered " >
        <thead>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td><button type="button" class="btn btn-danger" onclick="window.location.href='deleteaccount/${user.id}'" >Delete user account</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>



