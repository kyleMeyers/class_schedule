<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Major page</title>
		<link rel="stylesheet" type = "text/css" href = "${pageContext.servletContext.contextPath}/CSS/Layout.css">
			


	</head>
	<body>
	
	<div id = "container">
	
	<div id = "header">
		<h1> YCP Schedule Planner Prototype</h1>
	</div>
	<div id = "nav">
	
	<p id = "majorlist"></p>
	
	<ul>
	<c:forEach var="majorlist" items="${allMajors}">
		<li>${majorlist.name}</li>
	</c:forEach>
	
	</ul>
	</div>
	
	<div id = "section">
		<p>Hello ${user.username} please enter a Major</p>
		<form action="${pageContext.servletContext.contextPath}/major" method="post">
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Major:</td> -->
<!-- 					<td> -->
<%-- 						<input name = "major" type = "text" value = "${major}"></input> --%>
<!-- 					</td> -->
<!-- 			</table> -->
<!-- 			<input type="submit" name="submit" value="Enter Major"></input> -->
				<p> Major <input name="major" type = "text" value="${major}"></input></p>
				<input type="submit" name="submit" value="Enter Major"></input>
				
		</form>
		
		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
		
	</div>
	
	<div id = "footer">
	<p> No one reads the legal notice </p>
	</div>
	
	</div>
	

	</body>
</html>