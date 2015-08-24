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
		<c:if test="${not empty templateModelList}">
			<table>
				<tr>
					<td></td>
					<td>
						<spring:message code="admin.Maintain.NoticeTemplate.activityName" text="activityName"/>
					</td>
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
						<spring:message code="admin.Maintain.NoticeTemplate.ExpectedToSendDate" text="ExpectedToSendDate"/>
					</td>
					<td>
					</td>
				</tr>
				<c:forEach var="templateModel" items="${templateModelList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${templateModel.activityName}</td>
						<td>${templateModel.sessionsName}</td>
						<td>${noticeTypeList[templateModel.noticeType-1].reason}</td>
						<td>${templateModel.subject}</td>
						<td>
							<c:choose>
								<c:when test="${templateModel.noticeType == 2 || templateModel.noticeType == 3}">
									${templateModel.enrollNotice}
								</c:when>
								<c:when test="${templateModel.noticeType == 4}">
									${templateModel.dueNotice}
								</c:when>
							</c:choose>
						</td>
						<td>
							<spring:url var="editTemplateActionUrl" value="/admin/Maintain/editTemplate.do"/>
							<spring:url var="resendNoticeUrl" value="/admin/Maintain/resendNotice.do"/>
							<a href="${editTemplateActionUrl}?noticeId=${templateModel.noticeId}">
								<spring:message code="admin.Maintain.NoticeTemplate.edit" text="edit"/>
							</a>
							<c:choose>
								<c:when test="${templateModel.noticeType == 2 || templateModel.noticeType == 3}">
									<c:if test="${templateModel.resendEnroll}">
										&nbsp;&nbsp;
										<a href="${resendNoticeUrl}?noticeId=${templateModel.noticeId}">
											<spring:message code="admin.Maintain.NoticeTemplate.resend" text="resend"/>
										</a>
									</c:if>
								</c:when>
								<c:when test="${templateModel.noticeType == 4}">
									<c:if test="${templateModel.resendDue}">
										&nbsp;&nbsp;
										<a href="${resendNoticeUrl}?noticeId=${templateModel.noticeId}">
											<spring:message code="admin.Maintain.NoticeTemplate.resend" text="resend"/>
										</a>
									</c:if>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>