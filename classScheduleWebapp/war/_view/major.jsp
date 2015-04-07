<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Major page</title>
		<style>
			#header {
			background-color:green;
			color:white;
			text-align:center;
			padding: 5px;
			align:center;
			min-width:650px;
			max-width:750px;
			}
			
			#section {
    		float:left;
    		padding:5px;
    		text-align:center; 
    		align:center;
    		min-width:750px;
    		background-color:#FF33CC;
    		text-color:#00FF00;
			}
			
			#nav {
    		line-height:30px;
   		 	background-color:#eeeeee;
   			height:300px;
    		width:100px;
    		float:left;
    		padding:5px; 
			}
			
			#footer {
    		background-color:green;
    		color:white;
    		clear:both;
    		text-align:center;
    		padding:5px; 
    		min-width:650px;    		
			max-width:750px;
			}
			

		</style>
	</head>
	<body>
	
	<div id = "header">
		<h1> YCP Schedule Planner Prototype</h1>
	</div>
	
	<div id = "section">
		<p>Please enter a Major</p>
		<form action="${pageContext.servletContext.contextPath}/major" method="post">
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>Major:</td> -->
<!-- 					<td> -->
<%-- 						<input name = "major" type = "text" value = "${major}"></input> --%>
<!-- 					</td> -->
<!-- 			</table> -->
<!-- 			<input type="submit" name="submit" value="Enter Major"></input> -->
				<p> Major <input name="submit" value="Enter Major"></input></p>
		</form>
		
		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
		
	</div>
	
	<div id = "footer">
	<p> No one reads the legal notice </p>
	</div>
	</body>
</html>