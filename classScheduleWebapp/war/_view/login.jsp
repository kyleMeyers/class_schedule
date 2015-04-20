<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Login page</title>
		<link rel="stylesheet" type = "text/css" href = "${pageContext.servletContext.contextPath}/CSS/Layout.css">
		
	</head>
	
	<body>
	<div id = "container">		
		<div  id = "header" align = "center">
		<%--HI --%>
		
		<h1>Welcome to the YCP schedule planner prototype</h1>
		</div>
		
		
		<div id = "section">
		<p>Please log in.</p>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">

			<p> Username: <input name = "username" type=text value = "${username}"></input></p>
			<p> Password: <input name = "password" type=password value = "${password}"></input></p>
			<input type="submit" name="submit" value="Log in"></input>
		</form>
		
			<a href="${pageContext.servletContext.contextPath}/createAccount">Create new Account</a>
		</div>
		
		<div id = "footer" align = "center">
			<p>Legal notices go here</p>
			<p>Sponsored by Dr. Pepper</p>
		</div>

		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
	</div>
	</body>
</html>
