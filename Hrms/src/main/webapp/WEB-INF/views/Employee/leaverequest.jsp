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
</head>
<body>
	<h1>${user.id}</h1>

<c:url var="addAction" value="/Emp/sendLeaveRequest"></c:url>


	
	<form:form action="${addAction}" modelAttribute="employeeLeave">
		<table align="center">
			<tr>
			<tr>
				<td><form:hidden path="hrmsEmployeeDetails.empId"
						value="${user.id}" cssClass="focus1" /></td>
			</tr>
			<td>Leave ID</td>
			<td><form:select path="leaves.leaveId" cssClass="focus1">
					<form:option value="0" label="--- Select ---" />
					<c:forEach items="${LeavesList}" var="leaves">
						<form:option value="${leaves.leaveId}">${leaves.leaveName}
                   </form:option>
					</c:forEach>
				</form:select></td>

			<tr>
				<td>Start Date(*)</td>
				<td><form:input type="date" path="startDate" cssClass="focus1" /></td>
				<td><form:errors path="startDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>End Date(*)</td>
				<td><form:input type="date" path="endDate" cssClass="focus1" /></td>
				<td><form:errors path="endDate" cssClass="error" /></td>
			</tr>

			<tr>
				<td>No.of Days</td>
				<td><form:input path="totalDays" cssClass="focus1" /></td>
				<td><form:errors path="totalDays" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" /></td>

			</tr>

		</table>
		${Success}
	</form:form>
</body>
</html>