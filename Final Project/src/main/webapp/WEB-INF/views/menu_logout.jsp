<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
 <div class="container-fluid">
    <div class="navbar-header">
      <h2><a href="index.htm"><img src="resources/Images/dreamhome_logo1.jpg" width="120" height="50"></a></h2>
    </div>
<div style="float:right">
  <h4>  Hi ${sessionScope.username} | 
    <a href="logout.htm">Logout</a> </h4>

</div>
</div>
<nav class="navbar navbar-inverse">

    <span>
    <ul class="nav navbar-nav">
      <li><a href="index.htm">Home</a></li>
      <li><a href="#">Contact</a></li>
  
    </ul>
    </span>

</nav>

</body>
</html>