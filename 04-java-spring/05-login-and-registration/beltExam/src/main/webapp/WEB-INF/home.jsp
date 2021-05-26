<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="container-fluid">

		<h1>Welcome, <c:out value="${user.firstName} ${user.lastName}" /></h1>
		<a href="/logout">Logout</a>
		<a href="/newIdea">Create an idea</a>
				<h1>Ideas</h1>
					<table class="table table-striped table-dark">
				    <thead>
				        <tr>
				            <th>Ideas</th> 
				            <th>Created By:</th>
				            <th>Likes:</th>
				            <th>Action:</th>
				        </tr>
				    </thead>
				    <tbody>
				        	<c:forEach items="${ideas}" var="idea" varStatus="loop">
							<tr>    
							    <td><a href="/show/${idea.id}"><c:out value="${idea.content}"/></a></td>
							    <td><c:out value="${idea.creator.firstName} ${idea.creator.lastName}"/></td>
							    <td><p>${idea.likers.size()}</p></td>
							    <td><c:choose>
							 	<c:when test="${idea.likers.contains(user)}">
							 	<a href="/unlike/${idea.id}">Unlike</a>
							 	</c:when>
							 	<c:otherwise>
							 	<a href="/like/${idea.id}">Like</a>
							 	</c:otherwise>
							 	</c:choose>
							 	</td>
							</tr>
							</c:forEach>
				    </tbody>
				</table>
	</div>
</body>
</html>