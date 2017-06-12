<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Application Status</title>
	<link rel="stylesheet" href="css/loan.css" type="text/css" />
</head>

<body>
<h1> Application Status</h1><p/>
	<table class="display">
		<tr><td>First Name: </td><td><c:out value="${decision.loanApplication.applicant.name}" /></td></tr>
		<tr><td>Middle Name: </td><td><c:out value="${decision.loanApplication.applicant.middleName}" /></td></tr>
		<tr><td>Surname: </td><td><c:out value="${decision.loanApplication.applicant.surname}" /></td></tr>
		<tr><td>Loan Amount: </td><td><c:out value="${decision.loanApplication.appliedAmount}" /></td></tr>
		<tr><td>Credit Score: </td><td><c:out value="${decision.applicantCreditScore}" /></td></tr>
	</table>
</body>
</html>