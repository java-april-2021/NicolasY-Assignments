<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<div class = "container">
		<div class = "add">
			<h1>Welcome to the DMV! The fastest one on the planet!</h1>
			<a href="/person/new">Add Driver</a>
			<a href="/license/new">Add License</a>
		</div>
		<table class= "table table-dark table striped">
			<thead>
				<tr>
					<th>Name(Last, First)</th>
					<th>State:</th>
					<th>Driver's License Number:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${person}" var="{person}" varStatus="loop">
					<tr>
						<td><a href="/person/${person.id}"> ${person.lastName} , ${person.firstName}</a></td>
						<c:choose>
							<c:when test="${person.license != null}">
									<td>${person.license.state}</td>
									<td>${person.license.number}</td>
								</c:when>	
								<c:otherwise>
									<td><p>Ridin dirty</p></td>
								</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>