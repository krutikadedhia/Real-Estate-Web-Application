<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Login Form</title>
</head>
<body>

                <jsp:include page="menu.jsp"/>
        
<%-- <form:form action="login.htm" commandName="user" method="POST"> --%>
 <div class="container">
<h2>Welcome !! </h2><br>
 
 <fieldset class="scheduler-border">
    <legend class="scheduler-border"> Please Login</legend>
 <form:form action="login.htm" class="form-horizontal" role="form" commandName="user" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="username">Username:</label>
      <div class="col-sm-3">
        <form:input path="username" class="form-control" id="email" placeholder="Enter username" /> <font color="red"><form:errors path="username"/></font>
       
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-3"> 
      <form:password path="password" class="form-control" id="pwd" placeholder="Enter password" /> <font color="red"><form:errors path="password"/>  </font>       
        
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">

        <button type="submit" class="btn btn-default">Login</button>
      </div>
</div>
 </form:form>
 
 </fieldset>
</div>
</body>
</html>