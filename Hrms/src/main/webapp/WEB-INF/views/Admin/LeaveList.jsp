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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">



<style>
h2 {
	text-align: center;
}

table caption {
	padding: .5em 0;
}

@media screen and (max-width:600px) {
	table caption {
		border-bottom: 1px solid #ddd;
	}
}

.p {
	text-align: center;
	padding-top: 100px;
	font-size: 14px;
}
</style>

</head>
<body>
	<c:if test="${!empty leaves}">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th width="80">empId</th>
									<th width="120">leaveId</th>
									<th width="120">startDate</th>
									<th width="120">endDate</th>
									<th width="120">totalDays</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${leaves}" var="employee">
									<tr class="employeeTR">
										<td width="80">${employee.id}</td>
										<td width="80">${employee.hrmsEmployeeDetails.empId}</td>
										<td width="120">${employee.leaves.leaveId}</td>
										<td width="120">${employee.startDate}</td>
										<td width="120">${employee.endDate}</td>
										<td width="120">${employee.totalDays}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:if>


</body>
</html>