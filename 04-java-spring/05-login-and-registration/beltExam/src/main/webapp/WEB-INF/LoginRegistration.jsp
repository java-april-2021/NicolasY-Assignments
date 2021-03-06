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
					<h4>Register</h4>
					 <form:form method="post" action="/register" modelAttribute="user">
				       	<div class="form-group">
				       		<form:label path="firstName">First Name</form:label>
				       		<form:errors path="firstName"></form:errors>
				       		<form:input class="form-control" path="firstName"></form:input>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="lastName">Last Name</form:label>
				       		<form:errors path="lastName"></form:errors>
				       		<form:input class="form-control" path="lastName"></form:input>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="email">Email</form:label>
				       		<form:errors path="email"></form:errors>
				       		<form:input type="email" class="form-control" path="email"></form:input>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="password">Password</form:label>
				       		<form:errors path="password"></form:errors>
				       		<form:input type="password" class="form-control" path="password"></form:input>
				       	</div>
				       	<div class="form-group">
				       		<form:label path="passwordConfirmation">Confirm Password</form:label>
				       		<form:errors path="passwordConfirmation"></form:errors>
				       		<form:input type="password" class="form-control" path="passwordConfirmation"></form:input>
				       	</div>
				       	<input class="btn btn-standard" type="submit" value="Submit"/>
				    </form:form>
				</div>
				
			
				<div class="col">
					<p>${loginError}</p>
					<h4>Login</h4>
					<form:form method = "post" action="/login">
						<div class="form-group">
						<label>Email:</label>
						<input class="form-control" type="email" name="loginEmail">
						</div>
						<div class="form-group">
						<label>Password</label>
						<input class="form-control" type="password" name="loginPassword">
						
						<button class="btn btn-standard">Login</button>
					</form:form>
				</div>

			</div>
	</div>
</body>
</html>