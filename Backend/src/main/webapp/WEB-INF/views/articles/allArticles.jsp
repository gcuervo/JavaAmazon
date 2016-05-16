<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Articles</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Joining Date</td><td>Description</td><td>State</td><td></td>
		</tr>
		<c:forEach items="${articles}" var="article">
			<tr>
			<td>${article.name}</td>
			<td>${article.creationDate}</td>
			<td>${article.description}</td>
			<td><a href="<c:url value='/edit-${article.id}-user' />">${user.state}</a></td>
			<td><a href="<c:url value='/delete-${article.id}-user' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/registrationArticle' />">Add New Article</a>
</body>
</html>