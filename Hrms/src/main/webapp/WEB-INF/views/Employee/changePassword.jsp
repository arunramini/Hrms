<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/main.css" var="mainCss" />
<spring:url value="/resources/error.css" var="errCss" />
<link href="${mainCss}" rel="stylesheet" />
<link href="${errCss}" rel="stylesheet" />
</head>
<script>
	function validatePassWord(enterPass, oldPass) {
		if (enterPass != oldPass)
			alert("password is incorrect");

	}
</script>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:url var="addAction" value="/Emp/change"></c:url>

	<form:form action="${addAction}" modelAttribute="changePassword">
		<div class="col-sm-8 text-left">
			<div id="addEmployeeDiv">
				<table align="center">

					<tr>
						<td><form:hidden path="username" value="${user.username}"
								cssClass="focus1" />${user.username}</td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>

					<tr>

						<td><br>New Password</td>
						<td><br>
						<form:password path="password" cssClass="focus1" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr></tr>

					<tr>
						<td><br>
						<br>
						<input type="submit" value="changePassword" /></td>
					<tr>



					</tr>
				</table>
			</div>

		</div>
	</form:form>




</body>
</html>