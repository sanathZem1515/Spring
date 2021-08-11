<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>Save Hotel</title>

 <style>

            .error{
            color:red
            }

        </style>


</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Items</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Item</h3>

		<form:form action="save" modelAttribute="food" method="POST">


			<!-- need to associate this data with hotel id -->
			<form:hidden path="id" />


			<table>
				<tbody>
					<tr>
						<td><label>Item name:</label></td>
						<td><form:input path="itemName" />
						<form:errors path="itemName" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Item Price:</label></td>
						<td><form:input path="itemPrice" />
						<form:errors path="itemPrice" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label> itemRating:</label></td>
						<td><form:input path="itemRating" />
						<form:errors path="itemRating" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/food/list">Back to List</a>
		</p>

	</div>

</body>

</html>










