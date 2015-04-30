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
		<h2>${maj.name} Course List</h2>	
	
	</div>
	
	<div>
		<div id = "nav">
		<p>Username: <br> ${user.username}</p>
		<p>Major: <br> ${maj.name}</p>
		
		</div>
		
		<%-- If a major exists, displays the courses
			Currently displays all courses, instead of major specific --%>
		<div id = "section">

			<ul>
			<c:choose>
				<c:when test="${maj.name != null }">
					<c:forEach var="courselist" items="${allCourses}">
						<%-- How can we specify which course to give description for? 
						In this form, all courseList.name-s redirect to same page--%>
						<li>
							<a href="./courseDescription">
								${courselist.name}
							</a>
						</li>
					</c:forEach>
				</c:when>
			</c:choose>

			</ul>
		</div>
	
	</div>
	
	
	
	<div id = "section">
<!-- 		<input type="submit" name="submit" value="Click to add a new major"></input> -->
		<br>
		<a href="./major">
			<button>Click to add a new major</button>
		</a>
		
		<form action="${pageContext.servletContext.contextPath}/class" method="post">
			<input type="submit" name="submit" value="Display Courses"></input>
		</form>
	
	</div>
	
	<div id = "footer">
		<h6> I'm writing code</h6>
	
	</div>
	
	</div>
	
	
	
	</body>






</html>
