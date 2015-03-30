<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Login page</title>
		<style>
			body {background-color:lightgray}
		</style>
		
	</head>
	
	<body>
		
		<h1>Welcome to the YCP schedule planner prototype</h1>
		
		
		<div id = "section">
		<p>Please log in.</p>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<table>
				<tr>
					<td>Username:</td>
					<td>
						<input name="username" type="text" value="${username}"></input>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input name="password" type="password" value ="${password}"></input>
					</td>
				</tr>
			</table>
			<input type="submit" name="submit" value="Log in"></input>
		</form>
		</div>
		
		<div id = "footer">
			<p>Legal notices go here</p>
		</div>
		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
	</body>
</html>