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
						The number you are thinking of is ${app.guess}
					</div>
					<div>
						<input name="startApp" type="submit" value="Play again" />
					</div>
				</c:if>
				<c:if test="${!app.done}">
					<div>
						Are you thinking of ${app.guess}?
					</div>
					<div>
						<input name="gotIt" type="submit" value="Yes, that's it!" />
						<input name="less" type="submit" value="No, that's too big" />
						<input name="more" type="submit" value="No, that's too small" />
						
						<input name="min" type="hidden" value="${app.min}" />
						<input name="max" type="hidden" value="${app.max}" />
					</div>
				</c:if>
			</c:if>
		</form>
	</body>
</html>