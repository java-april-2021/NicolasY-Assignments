<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver Info</title>
</head>
<body>
		<div class ="">
			<h1>${person.firstName} ${person.lastName}</h1>
			<a href="/">Main Page</a>
			<p>License Number: ${person.license.getNumberAsString()}</p>
			<p>State: ${person.license.state}</p>
			<p>Expiration Date: ${person.license.getExpirationDateFormatted()}</p>
		</div>
</body>
</html>