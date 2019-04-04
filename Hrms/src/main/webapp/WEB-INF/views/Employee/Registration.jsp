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

	<c:url var="addAction" value="/Admin/saveEmployee"></c:url>


	<form:form action="${addAction}" modelAttribute="employee">

		<div>
			<table align="center">


				
				<tr>
					<td>Employee ID :</td>
					<td><form:input path="empId" /></td>
				</tr>
				<tr>
				<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				
				<tr>
					<td>LastName</td>
					<td><form:input path="lastName" /></td>
				</tr>
			 <tr>
					<td>midName</td>
					<td><form:input path="midName" /></td>
				</tr>
				
				 <tr>
					<td>sex</td>
					<td><form:input path="sex" /></td>
				</tr>
				<tr>
				<td>DepartmentId</td>
				<td><form:select path="department.deptId" cssClass="focus1">
					<form:option value="0" label="--- Select ---" />
					<c:forEach items="${departments}" var="leaves">
						<form:option value="${leaves.deptId}">${leaves.departmentName}
                   </form:option>
					</c:forEach>
				</form:select></td>
				</tr>
			<tr>
					<td>Start Date(*)</td>
					<td><form:input type="date" path="birthDate" cssClass="focus1" /></td>
				
				</tr>
			
			<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>
				
				
				<tr>
					<td>address</td>
					<td><form:input path="address" /></td>
				</tr>
				
				
				<tr>
					<td>employeedDate</td>
				
					<td><form:input type="date" path="employedDate" cssClass="focus1" /></td>

				</tr>
				
				<tr>
					<td>supervisorId</td>
					<td><form:input path="supervisorId" /></td>
				</tr>

				<tr>

					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</div>

	</form:form>
</body>
</html>