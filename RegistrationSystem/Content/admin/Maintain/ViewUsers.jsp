<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<dir>
		<spring:url var="newUsersActionUrl" value="/admin/Maintain/editUsers"/>
		<a href="${newUsersActionUrl}"><spring:message code="admin.Maintain.Users.addUser" text="addUser"/></a>
	</dir>
	<div>
		<table>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Users.username" text="username"/>
				</td>
				<td>
					<spring:message code="admin.Maintain.Users.userName" text="userName"/>
				</td>
				<td>
					<spring:message code="admin.Maintain.Users.email" text="email"/>
				</td>
				<td>
				</td>
			</tr>
			<c:forEach var="users" items="${listUsers}">
				<tr>
					<td>${users.username}</td>
					<td>${users.userName}</td>
					<td>${users.email}</td>
					<td>
						<spring:url var="editUsersActionUrl" value="/admin/Maintain/editUsers"/>
						<spring:url var="delUsersActionUrl" value="/admin/Maintain/delUsers"/>
						<a href="${editUsersActionUrl}?username=${users.username}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${delUsersActionUrl}?username=${users.username}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>