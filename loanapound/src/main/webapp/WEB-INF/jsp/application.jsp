<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Loan Application</title>
	<link rel="stylesheet" href="css/loan.css" type="text/css" />
</head>

<body>
<h1> Application Form</h1><p/>
<form:form method="POST" commandName="application">
	<table class="display">
		<tr><td>First Name: </td><td><form:input path="applicant.name" /></td></tr>
		<tr><td>Middle Name: </td><td><form:input path="applicant.middleName" /></td></tr>
		<tr><td>Surname:</td><td><form:input path="applicant.surname" /></td></tr>
		<tr><td>Loan Amount:</td><td><form:input path="appliedAmount" /></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="Register" /></td></tr>
</table>
</form:form>
</body>
</html>