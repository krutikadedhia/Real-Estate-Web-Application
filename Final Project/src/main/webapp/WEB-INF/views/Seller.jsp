<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Page</title>
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
<h2>Seller Page</h2>

  <form action="listprops.htm"  method="post">
  <input type="submit" value="Show Properties"  /> 
  </form>
 <h4>Add New Property</h4>
  <form action="addproperty.htm"  method="post">

<table cellpadding="5" cellspacing="5">
<tr>
    <td>Category Title:</td>
    <td><select name="category">
    <option value="Mid Range">Mid Range</option>
    <option value="Budget">Budget</option>
    <option value="Luxury">Luxury</option>
    <option value="Studio">Studio</option>
    <option value="Condos">Condos</option>
    <option value="Pet Friendly">Pet Friendly</option>
    <option value="Family">Family</option> 
</select>
</td>   
                   </tr> 
                <tr>
                    <td>No of beds:</td>
                   
                   <td> <select name="bed">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
 
</select></td>
                </tr>

				 <tr>
                    <td>No of bath:</td>
                  <td> <select name="bath">
    <option value="1">1</option>
    <option value="1.5">1.5</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>

 
</select></td>
                </tr>
                
                 <tr>
                    <td>Area in square feet:</td>
                     <td><input type="text" name="area" size="30" required/> <font color="red"></font></td>
                </tr>
				
				 <tr>
                    <td>Price in $:</td>
                     <td><input type="text" name="price" size="30" required /> <font color="red"></font></td>
                </tr>
                
                  <tr>
                    <td>Street</td>
                     <td><input type="text" name="street" size="30" required /> <font color="red"></font></td>
                </tr> 
                
                  <tr>
                    <td>City</td>
                     <td><input type="text" name="city" size="30" required /> <font color="red"></font></td>
                </tr> 
				
                      
				 <tr>
                    <td>Zip</td>
                     <td><input type="text" name="zip" size="30" required/> <font color="red"></font></td>
                </tr>

                 
                <tr>
                    <td colspan="2"><input type="submit" value="Post Property" /></td>
                </tr>
  
</table>
</form>
</div>
</body>
</html>
