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
			<h2>Hotel</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Hotel</h3>

		<form:form action="save" modelAttribute="hotel" method="POST">


			<!-- need to associate this data with hotel id -->
			<form:hidden path="hotelId" />


			<table>
				<tbody>
					<tr>
						<td><label>Hotel name:</label></td>
						<td><form:input path="hotelName" />
						<form:errors path="hotelName" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="hotelAddress" />
						<form:errors path="hotelAddress" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label> hotelRating:</label></td>
						<td><form:input path="hotelRating" />
						<form:errors path="hotelRating" cssClass="error"/></td>
					</tr>

		            <tr>
    					<td><label>phone number:</label></td>
    					<td><form:input path="phoneNum" />
    					<form:errors path="phoneNum" cssClass="error"/></td>
    				</tr>

    				<tr>
                        <td><label>Password:</label></td>
                        <td><form:input path="password" />
                        <form:errors path="password" cssClass="error"/></td>
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
			<a href="${pageContext.request.contextPath}/hotels/list">Back to List</a>
		</p>

	</div>

</body>

</html>










