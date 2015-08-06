<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>framework</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>
						<c:forEach var="framework" items="${user.framework}" varStatus="loop">
							${framework}
							<c:if test="${not loop.last}">,</c:if>
						</c:forEach>
					</td>
					<td>
						<spring:url value="/users/${user.id}" var="userUrl"/>
						<spring:url value="/users/${user.id}/update" var="updateUrl"/>
						<spring:url value="/users/${user.id}/delete" var="deleteUrl"/>
						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>