<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Buyer Page</title>
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
<h1>Buyer Page</h1>

  <form action="listProperties.htm" method="post">
  <input type="submit" value="Show Properties" />
  <!-- <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">List Properties</button> -->
    </form>
<br>
     <form action="showAgents.htm" method="post">
  <input type="submit" value="Show Agents" />
  
    </form>
    <br><br>
    <form action="search.htm" method="post">
            
            Search Property <input type="text" name="address" required /> <br>
            
            <label>Search By:</label>
            <input type="radio" name="searchkey" value="street" checked="checked"> Street
            <input type="radio" name="searchkey" value="city"> City
            <input type="radio" name="searchkey" value="zip"> Zip <br><br>
            
            <input type="hidden" name="action" value="searchproperty"/>
            <input type="submit" name="search"/>
        </form>
</div>
</body>
</html>