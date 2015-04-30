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
			<form action="${pageContext.servletContext.contextPath}/class" method="post">
			<ul>
			
			<c:choose>
				<c:when test="${maj.name != null }">
					
					<c:forEach var="courselist" items="${allCourses}">

						<%-- <input type="radio" name="coursetitle" value="${courselist.name}" checked>${courselist.name}
						<br> --%>
						<li>
							<input type ="radio" name ="courseItem" value ="${courselist.name}">${courselist.name}
							<br>
						</li>
					</c:forEach>
					
				</c:when>
			</c:choose>
			
			</ul>
			<input type="submit" name="submit" value="Display Courses"></input>
			
			</form>
		</div>
	
	</div>
	
	
	
	<div id = "section">
<!-- 		<input type="submit" name="submit" value="Click to add a new major"></input> -->
		<br>
		<a href="./major">
			<button>Click to add a new major</button>
		</a>
		

	
	</div>
	
	<div id = "footer">
		<h6> I'm writing code</h6>
	
	</div>
	
	</div>
	
	
	
	</body>






</html>
