<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Users</title>
<spring:url var="css" value="/static/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${css}" />
</head>
<body>
	<div class="container">
		<h1>Add Users</h1>
		<hr>
		<div>
			<spring:url value="/user/all" var="home"></spring:url>
			<a class="btn btn-default" href="${home}">Home</a>
		</div>
		<hr>
		<div>
			<spring:url
				value="${user.id == null ? '/user/save' : '/user/update'}"
				var="save" />
			<form:form modelAttribute="user" action="${save}" method="post">
				<form:hidden path="id" />
				<div class="form-group">
					<label for="name">Name: </label>
					<form:input path="name" class="form-control" />
				    <form:errors path="name" cssClass="label label-danger"/>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name: </label>
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName" cssClass="Label Label-danger" />
				</div>
				<div class="form-group">
					<label for="birthday">Birthday: </label>
					<form:input path="birthday" class="form-control" type="date" />
					<form:errors path="birthday" cssClass="Label Label-danger" />
				</div>
				<div class="form-group">
					<label for="birthday">Gender: </label>
					<form:select path="gender" class="form-control">
						<form:options items="${genders}" itemLabel="desc" />
					</form:select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Confirm</button>
				</div>
			</form:form>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2018 PauloFirmino</p>
		</footer>
	</div>
</body>
</html>