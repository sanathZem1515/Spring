<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>

	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    	<!-- Reference Bootstrap files -->
    	<link rel="stylesheet"
    		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

     <div class="jumbotron">
            <div class="container">
              <h1 class="display-3">Go Foodie</h1>
              <p>No more for hunger ! Go to have Food with GoFoodie with extreme satisfaction!</p>

              <p>Welcome <security:authentication property="principal.username" />! </p>
           </div>
          </div>

	<!-- display user name and role -->

           <div class ="container">

	                <security:authorize access="hasRole('ADMIN')">
                		<!-- Add a link to point to /leaders ... this is for the managers -->

                		<p>
                			<a href="${pageContext.request.contextPath}/hotels/list" class="btn btn-primary btn-lg" >Hotels List</a>
                		</p>
                	</security:authorize>

                	<security:authorize access="hasRole('HOTEL')">
                		<!-- Add a link to point to /systems ... this is for the admins -->

                		<p>
                			<a href="${pageContext.request.contextPath}/food/list" class="btn btn-primary btn-lg">Items List</a>


                		</p>

                		<p>
                             <a href="${pageContext.request.contextPath}/food/change-password" class="btn btn-primary btn-lg">Change password</a>

                        </p>
                	</security:authorize>




	<hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

		<input type="submit" class="btn btn-primary btn-lg" value="Logout" />
		</div>

	</form:form>

</body>

</html>