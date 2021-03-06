<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Create Idea</title>
</head>
<body>
<div class="container">
	<div class="row">
		<form:form action="/createIdea" method="POST" modelAttribute="idea">
			<form:input type="hidden" value="${user}" path="creator"/>
			<div class="form-group">
			<form:label path="content"><h3>Create a new idea</h3></form:label>
			<form:errors path="content"/>
			<form:textarea path="content"/>
			</div>
			<button class="btn btn-standard">Create</button>
		</form:form>
	</div>
</div>
</body>
</html>