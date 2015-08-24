<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<a href='<spring:url value="/admin/SignUpSearch.do"/>'>
			<spring:message code="admin.Maintain.Menu.SignUpSearch" text="SignUpSearch"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/admin/SignUpVerify.do"/>'>
			<spring:message code="admin.Maintain.Menu.SignUpVerify" text="SignUpVerify"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/admin/Maintain/Users.do"/>'>
			<spring:message code="admin.Maintain.Menu.MaintainUsers" text="MaintainUsers"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/admin/Maintain/Activity.do"/>'>
			<spring:message code="admin.Maintain.Menu.MaintainActivity" text="MaintainActivity"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/admin/Maintain/Sessions.do"/>'>
			<spring:message code="admin.Maintain.Menu.MaintainSessions" text="MaintainSessions"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/admin/Maintain/NoticeTemplate.do"/>'>
			<spring:message code="admin.Maintain.Menu.MaintainNoticeTemplate" text="MaintainNoticeTemplate"/>
		</a>&nbsp;&nbsp;
		<a href='<spring:url value="/j_spring_security_logout"/>'>
			<spring:message code="admin.Maintain.Menu.MaintainLogout" text="logout"/>
		</a>
	</div>
</body>
</html>