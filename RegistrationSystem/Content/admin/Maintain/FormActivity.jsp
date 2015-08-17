<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<spring:url var="activityActionUrl" value="/admin/Maintain/saveActivity"/>
	<form:form action="${activityActionUrl}" modelAttribute="activityForm" method="POST">
		<table>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Activity.ActivityForm.activityName" text="activityName"/>:
				</td>
				<td><form:input path="activityName"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<spring:message var="submitMsg" code="admin.Maintain.Activity.ActivityForm.submit" text="submit"/>
					<input type="submit" value="${submitMsg}"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>