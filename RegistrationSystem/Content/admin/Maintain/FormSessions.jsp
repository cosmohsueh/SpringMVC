<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='<spring:url value="/resources/js/jquery-1.11.3.js"/>'></script>
<script src='<spring:url value="/resources/js/jquery-ui.js"/>'></script>
<link rel="stylesheet" href='<spring:url value="/resources/css/jquery-ui.css"/>'>
</head>
<body>
	<jsp:include page="../../border/head.jsp"/>
	<spring:url var="sessionsActionUrl" value="/admin/Maintain/saveSessions.do"/>
	<form:form action="${sessionsActionUrl}" modelAttribute="sessionsForm" method="POST">
		<table>
			<form:hidden path="sessionsId"/>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.activityName" text="activityName"/>:
				</td>
				<td>
					<form:select path="activityId" items="${activityList}" itemLabel="activityName" itemValue="activityId"/>
					<form:errors path="activityId"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.sessionsName" text="sessionsName"/>:
				</td>
				<td>
					<form:input path="sessionsName"/>
					<form:errors path="sessionsName"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.startDate" text="startDate"/>:
				</td>
				<td>
					<form:input path="startDate" />
					<form:errors path="startDate"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.endDate" text="endDate"/>:
				</td>
				<td>
					<form:input path="endDate"/>
					<form:errors path="endDate"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.enrollNotice" text="enrollNotice"/>:
				</td>
				<td>
					<form:input path="enrollNotice"/>
					<form:errors path="enrollNotice"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="admin.Maintain.Sessions.SessionsForm.dueNotice" text="dueNotice"/>:
				</td>
				<td>
					<form:input path="dueNotice"/>
					<form:errors path="dueNotice"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<spring:message var="submitMsg" code="admin.Maintain.Sessions.SessionsForm.submit" text="submit"/>
					<spring:message var="cancelMsg" code="admin.Maintain.Sessions.SessionsForm.cancel" text="cancel"/>
					<input type="submit" value="${submitMsg}"/>
					&nbsp;&nbsp;
					<a href='<spring:url value="/admin/Maintain/Sessions.do"/>'>${cancelMsg}</a>
				</td>
			</tr>
		</table>
	</form:form>
	
	<script type="text/javascript">
		jQuery(function($){
		  $('#startDate').datepicker({dateFormat: "yy-mm-dd"});
		  $('#endDate').datepicker({dateFormat: "yy-mm-dd"});
		  $('#enrollNotice').datepicker({dateFormat: "yy-mm-dd"});
		  $('#dueNotice').datepicker({dateFormat: "yy-mm-dd"});
		});
	</script>
</body>
</html>