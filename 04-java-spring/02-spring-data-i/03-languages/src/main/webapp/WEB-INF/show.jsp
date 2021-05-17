<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show language</title>
	<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" type="text/css" href="css/styleEdit.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container-fluid">
		<a href="/languages">Dashboard</a>
		<h3>${lang.name}</h3>
		<p>${lang.creator}</p>
		<p>${lang.currentVersion}</p>
		<a href="/languages/${lang.id}/edit">Edit</a>
		<form class="linkButt" action="/language/${lang.id}" method="POST" >
		<input type="hidden" name="_method" value="delete">
		<input type="submit"  class="btn btn-link" value = Delete>
		</form>
	</div>
</body>
</html>
