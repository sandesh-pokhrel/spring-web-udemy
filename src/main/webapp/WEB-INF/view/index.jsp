<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<h1>Index Page</h1>
<h2>Useful Links</h2>
<hr>
<a href="${pageContext.request.contextPath}/showForm">Student Forms</a>
<hr>
<a href="${pageContext.request.contextPath}/retrieveStudents">Retrieve Students</a>
<hr>
<a href="${pageContext.request.contextPath}/retrieveStudentsOnGender/Male">Retrieve Male Students</a>
<hr>
<a href="${pageContext.request.contextPath}/retrieveStudentsOnGender/Female">Retrieve Female Students</a>
</body>
</html>