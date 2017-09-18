<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sign up Form</title>
</head>
<body>

  <jsp:include page="menu.jsp"/>
   <div class="container">
<h4>User Registration Form:</h4>

<form:form action="adduser.htm" name="frm1" commandName="user" method="POST">

<table >
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="username" size="30" /> <font color="red"><form:errors path="username"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email.emailId" size="30" /> <font color="red"><form:errors path="email.emailId"/></font></td>
</tr> 


<tr>
	<td>Select User Type:</td>
	<td><form:radiobutton path="type" value="Seller" />Seller
	<form:radiobutton path="type" value="Buyer" />Buyer
	<form:radiobutton path="type" value="Agent" />Agent  <font color="red"><form:errors path="type"/></font></td>
</tr>

</table>
<br>
   <input type="submit" onclick="formReset()" value="Save" />
</form:form>
</div>

<script>
function formReset()
{
    document.getElementById("frm1").reset();
}
</script>

</body>
</html>