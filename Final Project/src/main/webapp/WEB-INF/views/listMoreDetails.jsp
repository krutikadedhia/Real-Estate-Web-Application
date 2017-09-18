<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.user==null}">
        <c:redirect url="/login.htm"/>
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
      
        Details :
<table border="1" cellpadding="5" cellspacing="5">
            <c:forEach var="prop" items="${searchProperties}">
            <tr>
                <td><b>Category</b></td>
                <td>${prop.category}</td>
            </tr>
            <tr>
                <td><b>Number of Beds</b></td>
                <td>${prop.bed}</td>
            </tr>
            <tr>
                <td><b>Number of Baths</b></td>
                <td>${prop.bath}</td>
            </tr>
            <tr>
                <td><b>Price</b></td>
                <td>${prop.price}</td>
            </tr>
            <tr>
                <td><b>Area</b></td>
                <td>${prop.area}</td>
            </tr>
            
              <tr>
                <td><b>Street</b></td>
                <td>${prop.address.street}</td>
            </tr>
            
            <tr>
                <td><b>City</b></td>
                <td>${prop.address.city}</td>
            </tr>
          
            <tr>
                <td><b>Zipcode</b></td>
                <td>${prop.address.zip}</td>
            </tr>
            <tr> 
                <td><b>Status</b></td>
                <td>${prop.status}</td>
            </tr>
            <tr> 
                <td><b>Owner</b></td>
                <td>${prop.postedBy}</td>
            </tr>

            </c:forEach>
</table>
        </div>


</body>
</html>