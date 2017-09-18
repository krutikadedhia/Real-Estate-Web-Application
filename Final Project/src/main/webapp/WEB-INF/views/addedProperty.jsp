<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
     <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>User Created Successfully</title>
    </head>
    <body>
    
    <c:choose>
    <c:when test="${sessionScope.user==null}">
        <c:redirect url="/logout.htm"/>
    </c:when>    
</c:choose>
    
     <c:choose>
            <c:when test="${!empty sessionScope.userid}">
                <jsp:include page="menu_logout.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="menu.jsp"/>
            </c:otherwise>
        </c:choose>
         <div class="container">
         <h3>
        Property Posted Successfully: ${property.bed} bed ${property.bath} bath</h3><br>
        <h4>
        Category: ${property.category}<br>
        Posted by: ${sessionScope.username}
        </h4>
        </div>
        
    </body>
</html>