<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Foods</title>
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

	<div class = "container">
			<h2>Items List</h2>
            <hr>
            <br>
			<table class="table table-bordered table-striped">
               <thead class="thead-dark">
				<tr>
					<th>Item Name</th>
					<th>Item Price</th>
					<th>Item Rating</th>
				</tr>
				</thead>

                <tbody>
				<c:forEach var="tempFood" items="${foods}">
					<tr>
						<td> ${tempFood.itemName} </td>
						<td> ${tempFood.itemPrice} </td>
						<td> ${tempFood.itemRating} </td>
					</tr>
				</c:forEach>
                </tbody>
			</table>



    <br><br><br>
	<p>
        <a href="${pageContext.request.contextPath}/customer/">Back to Hotels</a>
    </p>
</body>

</html>









