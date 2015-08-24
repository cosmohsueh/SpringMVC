<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<h1>Sessions</h1>
	<div>
		<a href='<spring:url value="/admin/Maintain/editSessions.do"/>'>
			<spring:message code="admin.Maintain.Sessions.addSessions" text="addSessions"/>
		</a>
	</div>
	<div>
		<c:if test="${not empty sessionsList}">
			<table>
				<tr>
					<td>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.activityName" text="activityName"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.sessionsName" text="sessionsName"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.startDate" text="startDate"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.endDate" text="endDate"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.enrollNotice" text="enrollNotice"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.Sessions.dueNotice" text="dueNotice"/>
					</td>
					<td>
					</td>
				</tr>
				<c:forEach var="sessions" items="${sessionsList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${sessions.activityName}</td>
						<td>${sessions.sessionsName}</td>
						<td>${sessions.startDate}</td>
						<td>${sessions.endDate}</td>
						<td>${sessions.enrollNotice}</td>
						<td>${sessions.dueNotice}</td>
						<td>
							<spring:url var="editSessionsActionUrl" value="/admin/Maintain/editSessions.do"/>
							<spring:url var="delSessionsActionUrl" value="/admin/Maintain/delSessions.do"/>
							<a href="${editSessionsActionUrl}?sessionsId=${sessions.sessionsId}">
								<spring:message code="admin.Maintain.Sessions.edit" text="edit"/>
							</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="${delSessionsActionUrl}?sessionsId=${sessions.sessionsId}">
								<spring:message code="admin.Maintain.Sessions.delete" text="delete"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>