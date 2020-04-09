<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Customer confirmation</title>
</head>

<body>

	The customer is: ${customer.firstName } ${customer.lastName} 
	<br><br>
	Free passes: ${customer.freePasses}
	<br><br>
	Postal code: ${customer.postalCode}
	<br><br>
	Course code: ${customer.courseCode}

</body>

</html>