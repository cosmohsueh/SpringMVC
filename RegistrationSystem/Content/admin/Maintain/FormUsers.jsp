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
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.username" text="username"/>:
				</td>
				<td>
					<c:choose>
						<c:when test="${empty usersForm.username}">
							<form:input path="username"/>
						</c:when>
						<c:otherwise>
							${usersForm.username}
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.password" text="password"/>:
				</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.userName" text="userName"/>:
				</td>
				<td><form:input path="userName"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.UsersForm.email" text="email"/>:
				</td>
				<td><form:input path="email"/></td>
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