<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Major page</title>
	</head>
	<body>
		<p>Please enter a Major</p>
		<form action="${pageContext.servletContext.contextPath}/major" method="post">
			<table>
				<tr>
					<td>Major:</td>
					<td>
						<input name = "major" type = "text" value = "${major}"></input>
					</td>
			</table>
			<input type="submit" name="submit" value="Enter Major"></input>
		</form>
		
		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
	</body>
</html>