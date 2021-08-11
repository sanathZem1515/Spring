<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Hotels</title>
	<!-- reference our style sheet -->

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

	<div class="container">
			<h2>Hotels List</h2>

        <hr>

      	<button
      		onclick="window.location.href='showFormForAdd'; return false;"
   		   class="btn btn-primary btn-lg"
      	>Add Hotel </button>

      	<br><br>
			<!--  add our html table here -->
			<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Hotel Name</th>
					<th>Address</th>
					<th>Hotel Rating</th>
					<th>Phone Number</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>

				<!-- loop over and print our customers -->
				<c:forEach var="tempHotel" items="${hotels}">

             <!-- construct an "update" link with customer id -->
             <c:url var="updateLink" value="/hotels/showFormForUpdate">
             	<c:param name="hotelId" value="${tempHotel.hotelId}" />
        	 </c:url>

        	   <c:url var="deleteLink" value="/hotels/delete">
                          	<c:param name="hotelId" value="${tempHotel.hotelId}" />
                     	 </c:url>

					<tr>
						<td th:text > ${tempHotel.hotelName} </td>
						<td th:text > ${tempHotel.hotelAddress} </td>
						<td th:text > ${tempHotel.hotelRating} </td>
						<td th:text > ${tempHotel.phoneNum} </td>

                        <td>
						   <!-- display the update link -->
						    <a href="${updateLink}" class="btn btn-info btn-sm" >Update</a>
						    <a href="${deleteLink}" class="btn btn-info btn-sm" >Delete</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
			</table>

	</div>
        <br><br><br>
	<p>
    	<a href="${pageContext.request.contextPath}/">Back to Home</a>
    </p>
</body>
</html>









