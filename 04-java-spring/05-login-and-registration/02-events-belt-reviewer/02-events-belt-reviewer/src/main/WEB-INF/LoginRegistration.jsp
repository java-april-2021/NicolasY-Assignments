<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to the Login and Registration page!</h1>
			<div class="row">
				<div class="col">
					<p>${loginError}</p>
					<h4>Login</h4>
					<form method = "POST" action "/login">
					<div class="form-group">
					<label>Email:</label>
					<input class="form-control" type="email" name="LoginEmail">
					</div>
					<div class="form-group">
					<label>Password</label>
					<input class="form-control" type="password" name="LoginPassword">
				</div>
				<div class="col">
					<h4>Register</h4>
					 <form:form method="POST" action="/" modelAttribute="user">
				       	<div class="form-group">
				       		<form:label path="firstName">First Name</form:label>
				       		<form:errors path="firstName"/>
				       		<form:input class="form-control" path="firstName"/>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="lastName">Last Name</form:label>
				       		<form:errors path="lastName"/>
				       		<form:input class="form-control" path="lastName"/>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="email">Email</form:label>
				       		<form:errors path="email"/>
				       		<form:input type="email" class="form-control" path="email"/>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="password">Password</form:label>
				       		<form:errors path="password"/>
				       		<form:input type="password" class="form-control" path="firstName"/>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="confirmPassword">Confirm Password</form:label>
				       		<form:errors path="confirmPassword"/>
				       		<form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
				       	</div>
				       	<input class="btn btn-danger" type="submit" value="Submit"/>
				    </form:form>
				</div>
			</div>
	</div>
</body>
</html>