<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Certificate</title>
</head>
<body>
	<h2>Student Certificate output</h2><br /><br />
	<h4>The student certificate description is: ${studentCS.description } and roll not is: ${roll }</h4>
	<br /><br />
	<hr />
	<a href="${pageContext.request.contextPath}/index">Index Page</a>
</body>
</html>