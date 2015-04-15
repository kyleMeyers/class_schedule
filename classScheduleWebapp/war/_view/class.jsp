<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

	<head>
		<title>Major Course List</title>
		<link rel="stylesheet" type = "text/css" href = "${pageContext.servletContext.contextPath}/CSS/Layout.css">
	
	</head>
	
	<body>
	
	<div id = "container">
	<div id = "header">
		<h1>YCP Schedule Planner Prototype2</h1>
		<h2>${major} Course List</h2>
	
	
	</div>
	
	<div>
		<div id = "nav">
		<p>Username: <br> ${user.username}</p>
		<p>Major: <br> ${maj.name}</p>
		
		</div>
		
		<div id = "section">
			<ul >
				<c:forEach var="courselist" items="${allCourses}">
					<li>${courselist.name}</li>
				</c:forEach>
			</ul>
		
		</div>
	
	</div>
	
	
	
	<div id = "section">
	  <a href="${pageContext.servletContext.contextPath}/major">Add a new major</a> <br>
	  <a href="${pageContext.servletContext.contextPath}/somethingelse">Some other kind of action</a>
	
	</div>
	
	<form action="${pageContext.servletContext.contextPath}/class" method="Post">
		<input type="submit" name="action1" value="Click to add a new major"></input>
		
		
	</form>
	
	<form action="${pageContext.servletContext.contextPath}/class" method="Post">
		<input type="submit" name="action2" value="Click to add a new major"></input>
		
		
	</form>
	
	<div id = "footer">
		<h6> I'm writing code</h6>
	
	</div>
	
	</div>
	
	
	
	</body>






</html>