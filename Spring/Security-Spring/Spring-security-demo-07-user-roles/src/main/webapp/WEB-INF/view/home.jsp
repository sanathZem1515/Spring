<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>


	<p>
	Welcome to the luv2code company home page!
	</p>

    <hr>
    <!-- Display username and role -->

        <p>
            User:<security:authentication property="principal.username"/>
            <br><br>
            Role(s): <security:authentication property="principal.authorities"/>

    <hr>
    <!-- Add a link to point to /leaders .. this is for managers -->

    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (only for manager peeps)
    </p>

     <hr>
        <!-- Add a link to point to /systems .. this is for managers -->

        <p>
            <a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
            (only for admin peeps)
        </p>
    <hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>

</html>