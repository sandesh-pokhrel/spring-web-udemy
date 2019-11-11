<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Student Form</title>
	
	<style type="text/css">
		.error {
			color:red;
		}
	</style>
</head>
<body>
	<form:form title="Student Form" method="get" action="processForm" modelAttribute="student">
		<fieldset>
			<legend>Student Form</legend>
			Name: <form:input type="text" path="name" name="name" />
				  <form:errors path="name" cssClass="error"/><br /><br />
			Gender: <form:input type="text" path="gender" name="gender" />
					<form:errors path="gender" cssClass="error"/><br /><br />
			Postal Code: <form:input type="text" path="postalCode" name="postalCode" />
						<form:errors path="postalCode" cssClass="error"/><br /><br />
			Roll Number: <form:input type="text" path="rollNo" name="rollNo" />
						<form:errors path="rollNo" cssClass="error"/><br /><br />
			Country: <form:select path="country" items="${student.countryList }" /><br /><br />
			<input type="submit" value="Submit"/>
		</fieldset>
	</form:form>
	<br /><br />
	<form title="Retrive Student" method="get" action="retrieveStudent">
		<fieldset>
			<legend>Retrieve Student</legend>
			Roll No: <input type="text" name="roll" />
					 <input type="submit" value="Submit"/>
		</fieldset>
	</form>
	
	<br /><br />
	<form title="Update Student" method="get" action="updateStudent">
		<fieldset>
			<legend>Update Student</legend>
			Roll No: <input type="text" name="roll" />
					 <input type="submit" value="Submit"/>
		</fieldset>
	</form>
	
	<br /><br />
	
	<form:form title="Add Student Certificate" method="get" action="processFormStdCs" modelAttribute="studentCS">
		<fieldset>
			<legend>Add Student Certificate</legend>
			Description: <form:input type="text" name="description" path="description"/><br /><br />
			Roll No: <input type="text" name="roll" /><br /><br />
					 <input type="submit" value="Submit"/>
		</fieldset>
	</form:form>
	<br /><br />
	<hr />
	<a href="${pageContext.request.contextPath}/index">Index Page</a>
</body>
</html>