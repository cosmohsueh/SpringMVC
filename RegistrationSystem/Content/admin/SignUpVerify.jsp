<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="../border/head.jsp"/>
	<h1>SignUpVerify</h1>
	<div>
		<form action='<spring:url value="/admin/Verify.do"/>' method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<spring:message code="admin.SignUpVerify.checkImport" text="checkImport"/>:
					</td>
					<td>
						<input type="file" name="attachFile"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value='<spring:message code="admin.SignUpVerify.submitVerify" text="submit"/>'>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>