<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	
	<spring:url var="editActivityUrl" value="/admin/Maintain/editActivity"/>
	<a href="${editActivityUrl}">
		<spring:message code="admin.Maintain.Activity.addActivity" text="addActivity"/>
	</a>
	<dir>
		<table>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Activity.activityName" text="activityName"/>
				</td>
				<td>
				</td>
			</tr>
			<c:forEach var="activity" items="${activityList}">
				<tr>
					<td>${activity.activityName}</td>
					<td>
						<spring:url var="editActivityUrl" value="/admin/Maintain/editActivity"/>
						<spring:url var="delActivityUrl" value="/admin/Maintain/delActivity"/>
						<a href="${editActivityUrl}?activityId=${activity.activityId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${delActivityUrl}?activityId=${activity.activityId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</dir>
</body>
</html>