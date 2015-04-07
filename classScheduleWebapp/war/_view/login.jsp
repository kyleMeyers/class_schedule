<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Login page</title>
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
    		padding:10px;
    		text-align:center; 
    		align:center;
    		min-width:700px;
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
		
		<div  id = "header" align = "center">
		<%--HI --%>

			
		
		<h1>Welcome to the YCP schedule planner prototype</h1>
		</div>
		
		
		<div id = "section" align = "center">
		<p>Please log in.</p>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
<%-- 			<table>
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
			</table> --%>
			<p> Username: <input name = "username" type=text" value = "${username}"></input></p>
			<p> Password: <input name = "password" type=text" value = "${password}"></input></p>
			<input type="submit" name="submit" value="Log in"></input>
		</form>
		</div>
		
		<div id = "footer" align = "center">
			<p>Legal notices go here</p>
			<p>Sponsered by Dr. Pepper</p>
		</div>
		<c:if test="${! empty error}">
			<p class="error">${error}</p>
		</c:if>
	</body>
</html>