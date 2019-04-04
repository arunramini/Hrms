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
<spring:url value="/resources/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>

<h1> hey</h1>

	<c:if test="${!empty viewProfile}">
		<h3>MY Profile</h3>

		<div class="center">
			<div class="pagination">
				<table class="tg" border=1>
					<tr class="employeetHeader">
						<th>ID</th>
						<th width="80">firstName</th>
						<th width="120">lastName</th>
						<th width="120">midName</th>
						<th width="120">birthDate</th>
						<th width="120">age</th>
						<th width="120">sex</th>
						<th width="120">address</th>
						<th width="120">employedDate</th>
						<th width="120">supervisorId</th>
			
					</tr>
					<c:forEach items="${viewProfile}" var="employee">

						<tr class="employeeTR">
							<td width="80">${employee.empId}</td>
							<td width="120">${employee.firstName}</td>
							<td width="120">${employee.lastName}</td>
							<td width="120">${employee.midName}</td>
							<td width="120">${employee.birthDate}</td>
							<td width="120">${employee.age}</td>
							<td width="120">${employee.sex}</td>
							<td width="120">${employee.address}</td>
							<td width="120">${employee.employedDate}</td>
							<td width="120">${employee.supervisorId}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</c:if>
</body>
</html>