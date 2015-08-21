<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<spring:url var="usersActionUrl" value="/admin/Maintain/saveUsers"/>
	<form:form action="${usersActionUrl}" modelAttribute="usersForm" method="POST">
		<table>
			<form:hidden path="userId"/>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.username" text="username"/>:
				</td>
				<td>
					<form:input path="username" readonly="${not empty usersForm.username}"/>
					<form:errors path="username"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.password" text="password"/>:
				</td>
				<td>
					<form:password path="password"/>
					<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.userName" text="userName"/>:
				</td>
				<td>
					<form:input path="userName"/>
					<form:errors path="userName"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.email" text="email"/>:
				</td>
				<td>
					<form:input path="email"/>
					<form:errors path="email"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<spring:message var="submitMsg" code="admin.Maintain.Users.UsersForm.submit" text="submit"/>
					<spring:message var="cancelMsg" code="admin.Maintain.Users.UsersForm.cancel" text="cancel"/>
					<input type="submit" value="${submitMsg}"/>
					&nbsp;&nbsp;
					<a href='<spring:url value="/admin/Maintain/Users"/>'>
						${cancelMsg}
					</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>