<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Class Schedule</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/schedule" method="post">
			<c:if test="${empty app}">
				<input name="startApp" type="submit" value="Start App" />
			</c:if>
			<c:if test="${! empty app}">
				<c:if test="${app.done}">
					<div>
						Your ID is ${app.id}
					</div>
					<div>
						<input name="startApp" type="submit" value="Start Again?" />
					</div>
				</c:if>
				<c:if test="${!app.done}">
					<div>
						What is your user name ${app.username}?
					</div>
					<div>
						<input name="gotIt" type="submit" value="Valid Username" />
						<input name="not" type="submit" value="Invalid Username" />
						
						<input name="min" type="hidden" value="${app.min}" />
						<input name="max" type="hidden" value="${app.max}" />
					</div>
				</c:if>
			</c:if>
		</form>
	</body>
</html>