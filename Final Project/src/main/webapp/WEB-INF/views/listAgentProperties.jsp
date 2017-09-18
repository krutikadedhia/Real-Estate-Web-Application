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
      
        Properties Posted :
<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <th><b>Category</b></th>
                <th><b>Bed</b></th>
                <th><b>Bath</b></th>
                <th><b>Area</b></th>
                <th><b>Price</b></th>
                <th><b>Posted By</b></th>
                <th><b>Street</b></th>
                <th><b>City</b></th>
                <th><b>Zip</b></th>                
                <th><b>Status</b></th>
                <th><b>Buyer</b></th>
                <th><b></b></th>
            </tr>
            <c:forEach var="prop" items="${properties}">
                <tr>
                    <td>${prop.category}</td>
                    <td>${prop.bed}</td>
                    <td>${prop.bath}</td>
                    <td>${prop.area}</td>
                    <td>${prop.price}</td>
                    <td>${prop.postedBy}</td>
                    <td>${prop.address.street}</td>
                	<td>${prop.address.city}</td>
                	<td>${prop.address.zip}</td>
                    <td>${prop.status}</td>
                    <td>${prop.buyer}</td>
                   <!--  <td><a href="deleteProperty.htm">Delete</a></td> -->
                 </tr>
            </c:forEach>
         
        </table>

        </div>


</body>
</html>