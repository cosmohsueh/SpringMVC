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
	<spring:url var="sessionsActionUrl" value="/admin/Maintain/saveSessions"/>
	<form:form action="${sessionsActionUrl}" modelAttribute="usersForm" method="POST">
		<table>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.sessionsName" text="sessionsName"/>:
				</td>
				<td><form:input path="sessionsName"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.startDate" text="startDate"/>:
				</td>
				<td><form:password path="startDate"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.endDate" text="endDate"/>:
				</td>
				<td><form:input path="endDate"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.enrollNotice" text="enrollNotice"/>:
				</td>
				<td><form:input path="enrollNotice"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.dueNotice" text="dueNotice"/>:
				</td>
				<td><form:input path="dueNotice"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<spring:message var="submitMsg" code="admin.Maintain.Users.UsersForm.submit" text="submit"/>
					<input type="submit" value="${submitMsg}"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>