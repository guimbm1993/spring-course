<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>luv2code Company Home Page</title>
</head>
<body>

	<h2>Hello new app is comming</h2>
	
	<p>
		Welcome to the luv2code company home page!
	</p>
	
	<!-- Add logout button  -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>

</body>
</html>