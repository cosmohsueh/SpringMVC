<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<h1>MaintainNoticeTemplate</h1>
	<div>
		<c:if test="${not empty noticeList}">
			<table>
				<tr>
					<td></td>
					<td>
						<spring:message code="admin.Maintain.NoticeTemplate.sessionsName" text="sessionsName"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.NoticeTemplate.noticeType" text="noticeType"/>
					</td>
					<td>
						<spring:message code="admin.Maintain.NoticeTemplate.subject" text="subject"/>
					</td>
					<td>
					</td>
				</tr>
				<c:forEach var="notice" items="${noticeList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>
							<c:forEach var="sessions" items="${sessionsList}">
								<c:if test="${sessions.sessionsId == notice.sessionId}">
									${sessions.sessionsName}
								</c:if>
							</c:forEach>
						</td>
						<td>${noticeTypeList[notice.noticeType-1].reason}</td>
						<td>${notice.subject}</td>
						<td>
							<spring:url var="editTemplateActionUrl" value="/admin/Maintain/editTemplate"/>
							<a href="${editTemplateActionUrl}?noticeId=${notice.noticeId}">
								<spring:message code="admin.Maintain.NoticeTemplate.edit" text="edit"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>