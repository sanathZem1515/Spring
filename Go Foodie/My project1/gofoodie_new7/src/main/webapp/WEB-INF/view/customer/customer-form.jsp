<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title> Go Foodie </title>

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

      <style>
           html, body{
           	margin-left:15px; margin-right:15px;
           	padding:0px;
           	font-family:Verdana, Arial, Helvetica, sans-serif;
           }
        </style>
</head>

<body>
    <div class ="container ">
        <h1> CHOOSE YOUR HOTEL !</h1>


     <br><br>

        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
        	<tr>
        	    <th>Hotel Name</th>
        	    <th>Action</th>
        	</tr>
          </thead>
           <tbody>
             <c:forEach var="tempHotel" items="${hotels}">
                <tr>
                    <td>
                        ${tempHotel.hotelName}
                    </td>
                    <td>
                        <c:url var="link" value="/customer/hotel">
                                                    <c:param name="hotelName" value="${tempHotel.hotelName}" />
                                                </c:url>
                        <a href="${link}" class="btn btn-primary btn-sm"> view items  </a>
                    </td>
                </tr>
             </c:forEach>
           </tbody>
        </table>

      <p>
            <a href="${pageContext.request.contextPath}/">Back to Sign in</a>
       </p>

</body>
</html>