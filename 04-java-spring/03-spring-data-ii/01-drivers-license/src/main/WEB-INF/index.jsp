<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
<a href="/">Main Page</a>
<h1>New Person</h1>
<div class="add">
<form:form method="POST" action="" modelAttribute="person">
	<p class = "form-group">
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input class="form-control" path="firstName"/>
	</p>
	<p class = "form-group">
		<form:label path="lastName">Last Name</form:label>
		<form:errors path="lastName"/>
		<form:input class="form-control" path="lastName"/>
	</p>
	<input type="submit" value="Add Person"/>
</form:form>
</div>
</body>
</html>