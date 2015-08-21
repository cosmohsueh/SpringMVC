<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='<spring:url value="/resources/ckeditor/ckeditor.js"/>'></script>
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<spring:url var="saveTemplateUrl" value="/admin/Maintain/saveTemplate"/>
	<form:form action="${saveTemplateUrl}" method="POST" modelAttribute="templateForm">
		<table>
			<form:hidden path="noticeId"/>
			<tr>
				<td>
					<spring:message code="admin.Maintain.NoticeTemplate.templateForm.sessionsName" text="sessionsName"/>:
				</td>
				<td>
					<form:select path="sessionId" items="${sessionsList}" itemLabel="sessionsName" itemValue="sessionsId" disabled="true" />
					<form:hidden path="sessionId"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.NoticeTemplate.templateForm.noticeType" text="noticeType"/>:
				</td>
				<td>
					<form:select path="noticeType" items="${noticeTypeList}" itemLabel="reason" itemValue="code" disabled="true"/>
					<form:hidden path="noticeType"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.NoticeTemplate.templateForm.subject" text="subject"/>:
				</td>
				<td>
					<form:input path="subject"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.NoticeTemplate.templateForm.content" text="content"/>:
				</td>
				<td>
					<form:textarea path="content" cols="30" rows="20"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value='<spring:message code="admin.Maintain.NoticeTemplate.templateForm.submit" text="submit"/>' />
					&nbsp;&nbsp;
					<a href='<spring:url value="/admin/Maintain/NoticeTemplate"/>'>
						<spring:message code="admin.Maintain.NoticeTemplate.templateForm.cancel" text="cancel"/>
					</a>
				</td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
	CKEDITOR.replace( 'content' );
	</script>
</body>
</html>