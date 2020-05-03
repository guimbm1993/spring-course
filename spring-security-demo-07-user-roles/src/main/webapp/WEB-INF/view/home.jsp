<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>luv2code Company Home Page</title>
</head>
<body>

	<p>Welcome to the luv2code company home page!</p>

	<hr>

	<p>

		User:
		<security:authentication property="principal.username" />
		<br>
		<br> Roles:
		<security:authentication property="principal.authorities" />

	</p>

	<security:authorize access="hasRole('MANAGER')">
		<!-- add a link to point to /leaders... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a>(Only for manager peeps)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- add a link to point to /systems... this is for the admin -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				meeting</a>(Only for admin peeps)
		</p>
	</security:authorize>

	<hr>

	<!-- Add logout button  -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>