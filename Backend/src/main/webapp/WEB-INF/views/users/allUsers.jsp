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
	<h2>List of Users</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Joining Date</td><td>User Name</td><td>Email</td><td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.name}</td>
			<td>${user.creationDate}</td>
			<td>${user.user}</td>
			<td><a href="<c:url value='/edit-${user.email}-user' />">${user.email}</a></td>
			<td><a href="<c:url value='/delete-${user.email}-user' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/registrationUser' />">Add New User</a>
</body>
</html>