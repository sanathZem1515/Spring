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
		<h3>Change Password </h3>

		<form:form action="savePassword" modelAttribute="user" method="POST">


			<!-- need to associate this data with hotel id -->
			<form:hidden path="username" />
			<form:hidden path="enabled" />

			<table>
				<tbody>
					<tr>
						<td><label>New Password:</label></td>
						<td><form:input path="password" />
						<form:errors path="password" cssClass="error"/> </td>
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










