<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Article Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Articles Form</h2>
 
	<form:form method="POST" modelAttribute="article">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
   		    <tr>
				<td><label for="id_user">ID USER: </label> </td>
				<td><form:input path="id_user" id="id_user"/></td>
				<td><form:errors path="id_user" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for="description">Description: </label> </td>
				<td><textarea path="description" id="description" name="description"></textarea></td>
				<td><form:errors path="description" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for="status">State: </label> </td>
				<td><form:input path="state" id="state"/></td>
				<td><form:errors path="state" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for="privacy">*Privacy: </label> </td>
				<td><form:input path="privacy" id="privacy"/></td>
				<td><form:errors path="privacy" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/listArticles' />">List of All Articles</a>
</body>
</html>