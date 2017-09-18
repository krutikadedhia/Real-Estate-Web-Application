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
        
     
        <h3>List of Agents:</h3>
<table border="1" cellpadding="5" cellspacing="5" width="70%">
            <tr>
                
                <th><b>FirstName</b></th>
                <th><b>Email</b></th>
                <th><b>Message</b></th>
            </tr>
            <c:forEach var="agent" items="${users}">
                <tr>
                  
                    <td>${agent.username}</td>
                   <%--  <td>${agent.lastname}</td> --%>
                    <td width="40%">${agent.email.emailId}</td>
                    <td>
                     <form action="sendMessage.htm?agentname=${agent.username}" method="post">
                   <textarea name="message" rows="3" cols="47"></textarea>
                   <input type="submit" value="Send" /> 
                   </form>
                   </td>
                  <%--   <td>${prop.postedBy}</td>
                	<td>${prop.address.zip}</td>
                	<td>${prop.address.city}</td>
                    <td>${prop.status}</td> --%>
                     </tr>
            </c:forEach>
        </table>

        </div>



</body>
</html>