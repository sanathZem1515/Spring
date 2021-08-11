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

	<div class="container">
			<h2>Items List</h2>
	<hr>


     <button
      		onclick="window.location.href='showFormForAdd'; return false;"
      			class="btn btn-primary btn-lg"
      >Add Item </button>
			<!--  add our html table here -->

		<br><br><br>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Item Name</th>
					<th>Item Price</th>
					<th>Item Rating</th>
					<th>Action</th>
				</tr>
            </thead>

            <tbody>
			<c:forEach var="tempFood" items="${foods}">

             <c:url var="updateLink" value="/food/showFormForUpdate">
             	<c:param name="itemId" value="${tempFood.id}" />
        	 </c:url>

        	 <c:url var="deleteLink" value="/food/delete">
                <c:param name="itemId" value="${tempFood.id}" />
             </c:url>

             <tr>
				<td th:text > ${tempFood.itemName} </td>
				<td th:text > ${tempFood.itemPrice} </td>
				<td th:text > ${tempFood.itemRating} </td>

                 <td>
					<a href="${updateLink}" class="btn btn-info btn-sm">Update</a>
				    <a href="${deleteLink}" class="btn btn-info btn-sm">Delete</a>
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









