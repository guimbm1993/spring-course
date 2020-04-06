<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>

	<h2>Student registration form</h2>


	The student confirmed is: ${student.firstName} ${student.lastName}


	<br>
	<br> From: ${student.country}
	
	<br>
	<br>
	Favorite Language: ${student.favoriteLanguage }
	
	<br>
	<br>
	
	Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp }</li>
		</c:forEach>
	</ul>


</body>

</html>