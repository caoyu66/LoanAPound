<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Loan Application</title>
	<link rel="stylesheet" href="css/loan.css" type="text/css" />
</head>

<body>
<h1> Application Form</h1><p/>
<form:form method="POST" commandName="applicant">
	<form:errors />
	<table class="display">
		<tr>
			<td>Email: </td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email"  /></td>
		</tr><tr>
			<td>First Name: </td>
			<td><form:input path="name" /></td>
		</tr><tr>
			<td>Middle Name: </td>
			<td><form:input path="middleName" /></td>
		</tr><tr>
			<td>Surname:</td>
			<td><form:input path="surname" /></td>
			<td><form:errors path="surname"  /></td>
		</tr><tr>
			<td colspan="2" align="center"><input type="submit" value="Register" /></td>
		</tr>
</table>
</form:form>
</body>
</html>