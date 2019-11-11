<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
	<p>Name is: ${student.name }<br>Gender is: ${student.gender }<br>Country is: ${student.country }<br>Postal Code: ${student.postalCode }
	<br>Roll No: ${student.rollNo }</p>
	<hr />
	<a href="${pageContext.request.contextPath}/index">Index Page</a>
</body>
</html>