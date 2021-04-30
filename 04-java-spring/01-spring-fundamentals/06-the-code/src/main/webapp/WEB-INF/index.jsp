<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
</head>
<body>
	<h1>What is the code?</h1>
	<form action="/attempt" method="post">
	<span><c:out value="${ error }" /></span>
		<input type="text" name="guess" placeholder="What is the code?" />
		<button>Try Code</button>
	</form>
</body>
</html>