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
<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <th><b>Category</b></th>
                <th><b>Bed</b></th>
                <th><b>Bath</b></th>
                <th><b>City</b></th>
                <th><b>Status</b></th>
                <th><b>More Details</b></th>
                <th><b></b></th>
            </tr>
            <c:forEach var="prop" items="${properties}">
                <tr>
                    <td>${prop.category}</td>
                    <td>${prop.bed}</td>
                    <td>${prop.bath}</td>
                	<td>${prop.address.city}</td>
                	<td><a href="<c:out value='viewMoreDetails.htm?propId=${prop.propertyid}' />">View More Details</a></td>
                    <td>${prop.status}</td>
                    <c:choose>
                    <c:when test="${empty prop.buyer}">
                    <td><a href="#" data="${prop.propertyid}" class="assign">Buy this property</a></td>
                    </c:when>
                    <c:otherwise>
                    <td>This house is no longer on sale</td>
                    </c:otherwise>
                    </c:choose>
                     </tr>
            </c:forEach>
        </table>
        </div>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>

<script type="text/javascript">
    $(document).ready(function() {

        $('.assign').click(function() {
            //e.preventDefault();
        	var record=$(this);
            var data = $(this).attr("data");
            $.ajax({
                url : 'markComplete.htm',
                data : {
                    propertyID : data
                },
                success : function(res) {
                    if(res=="success"){
                    $(record).parent().prev().text("Sold");
                    $(record).parent().text("");
                    $("#success").html("Task Marked Completed");
                    }
                }
            });
        });
    });
</script>


</body>
</html>