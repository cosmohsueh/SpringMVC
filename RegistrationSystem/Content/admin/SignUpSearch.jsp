<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='<spring:url value="/resources/js/jquery-1.11.3.js"/>'></script>
</head>
<body>
	<jsp:include page="../border/head.jsp"/>
	<h1>signupSearch</h1>
	<div>
		<spring:url var="SignUpSearchActionUrl" value="/admin/SignUpSearch.do"/>
		<form:form action="${SignUpSearchActionUrl}" modelAttribute="signUpSearchForm" method="POST">
			<table>
				<tr>
					<td>
						<spring:message code="admin.SignUpSearch.searchForm.activityName" text="activityName"/>:
					</td>
					<td>
						<form:select path="activityId"/>
					</td>
				</tr>
				<tr>
					<td>
						<spring:message code="admin.SignUpSearch.searchForm.sessionsName" text="sessionsName"/>:
					</td>
					<td>
						<form:select path="sessionsId"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<spring:message var="submitMsg" code="admin.SignUpSearch.searchForm.submit" text="submit"/>
					<input type="submit" value="${submitMsg}"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	<div>
		<c:if test="${not empty applicantsList}">
			<table>
				<tr>
					<td colspan="2">
						<spring:message code="admin.SignUpSearch.activityName" text="activityName"/>:
					</td>
					<th colspan="2">${activityName}</th>
				</tr>
				<tr>
					<td colspan="2">
						<spring:message code="admin.SignUpSearch.sessionsName" text="sessionsName"/>:
					</td>
					<th colspan="2">${sessionsName}</th>
				</tr>
				<tr>
					<td></td>
					<td>
						<spring:message code="admin.SignUpSearch.confirm" text="confirm"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.fullName" text="fullName"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.nationalIdNumber" text="nationalIdNumber"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.organization" text="organization"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.position" text="position"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.tel" text="tel"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.cell" text="cell"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.email" text="email"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.stay" text="stay"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.pickUp" text="pickUp"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.gender" text="gender"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.meals" text="meals"/>
					</td>
					<td>
						<spring:message code="admin.SignUpSearch.applicantsDate" text="applicantsDate"/>
					</td>
				</tr>
				<c:forEach var="applicants" items="${applicantsList}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${applicants.confirmEnum}</td>
						<td>${applicants.fullName}</td>
						<td>${applicants.nationalIdNumber}</td>
						<td>${applicants.organization}</td>
						<td>${applicants.position}</td>
						<td>${applicants.tel}</td>
						<td>${applicants.cell}</td>
						<td>${applicants.email}</td>
						<td>${applicants.stayEnum}</td>
						<td>${applicants.pickUpEnum}</td>
						<td>${applicants.genderEnum}</td>
						<td>${applicants.mealsEnum}</td>
						<td>${applicants.applicantsDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<spring:url var="downloadExcelUrl" value="/admin/downloadExcel.do"/>
						<a href="${downloadExcelUrl}?sessionsId=${sessionsId}">
							<spring:message code="admin.SignUpSearch.searchForm.print" text="print"/>
						</a>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
	<spring:url var="ActivityJson" value="/admin/ActivityJson.do"/>
	<spring:url var="sessionJson" value="/admin/SessionsJson.do"/>
	<script type="text/javascript">
	jQuery(function($){
		$.getJSON('${ActivityJson}', 
		function(data) {
			var html = '<option value=""></option>';
			data.sort(function(a,b){
			    a = a.activityId;
			    b = b.activityId;
			    return a-b;
			});
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				html += '<option value="' + data[i].activityId + '">'
						+ data[i].activityName + '</option>';
			}
			html += '</option>';
			$('#activityId').html(html);
		});
		$('#activityId').change(function () {
			$.getJSON('${sessionJson}', {
				activityId : $(this).val()
			}, function(data) {
				var html = '<option value=""></option>';
				data.sort(function(a,b){
				    a = a.sessionsId;
				    b = b.sessionsId;
				    return a-b;
				});
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].sessionsId + '">'
							+ data[i].sessionsName + '</option>';
				}
				html += '</option>';
				$('#sessionsId').html(html);
			});
		});
	});
	</script>
</body>
</html>