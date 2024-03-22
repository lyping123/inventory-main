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
   
    <h1>Welcome to products management website</h1>
    <p>Click <a href="products">here</a> for more detail</p>
    <a href="/products" >
        <img style="width: 100%;" src="/images/vegetablesimg.jpg" alt="vegetable" />
    </a>
	
    
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>



