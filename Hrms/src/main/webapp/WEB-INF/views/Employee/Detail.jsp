<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Profile</title>

<spring:url value="/resources/EmployeeDetail.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>

<body>

	<c:if test="${!empty viewProfile}">
		<c:forEach items="${viewProfile}" var="employee">
			<div id="user-profile-2" class="user-profile">


				<div class="tab-content no-border padding-24">
					<div id="home" class="tab-pane in active">
						<div class="row">
							<div class="col-xs-12 col-sm-3 center">
								<span class="profile-picture"> <c:set var="sex"
										scope="session" value="${employee.sex}" /> <c:choose>
										<c:when test="${sex == 'M'}">
											<img class="editable img-responsive" alt=" Avatar"
												id="avatar2"
												src="http://bootdey.com/img/Content/avatar/avatar6.png">
										</c:when>

										<c:when test="${sex == 'F'}">
											<img class="editable img-responsive" alt=" Avatar"
												id="avatar2"
												src="  https://www.bootdey.com/img/Content/avatar/avatar5.png">
										</c:when>


									</c:choose>

								</span>

								<div class="space space-4"></div>


							</div>


							<div class="col-xs-12 col-sm-9">
								<h4 class="blue">
									<span class="middle">${employee.firstName}</span> <span
										class="label label-purple arrowed-in-right"> <i
										class="ace-icon fa fa-circle smaller-80 align-middle"></i>
										online
									</span>
								</h4>

								<div class="profile-user-info">
									<div class="profile-info-row">
										<div class="profile-info-name">Name</div>

										<div class="profile-info-value">
											<span>${employee.firstName} ${employee.lastName}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Location</div>

										<div class="profile-info-value">
											<i class="fa fa-map-marker light-orange bigger-110"></i> <span>${employee.address}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Sex</div>

										<div class="profile-info-value">
											<span>${employee.sex}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Employed Date</div>

										<div class="profile-info-value">
											<span>${employee.employedDate}</span>
										</div>
									</div>


									<div class="profile-info-row">
										<div class="profile-info-name">Age</div>

										<div class="profile-info-value">
											<span>${employee.age}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Birth Date</div>

										<div class="profile-info-value">
											<span>${employee.birthDate}</span>
										</div>
									</div>


								</div>
							</div>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->

					<div class="space-20"></div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title smaller">
										<i class="ace-icon fa fa-check-square-o bigger-110"></i> <b>Little
											About Me</b>
									</h4>
								</div>

								<div class="widget-body">
									<div class="widget-main">
										<p>
											<l>My name is </l>${employee.firstName}<l>,</l>
											I have many hobbies and interests, but usually not enough
											time pursue them all as much as I would like. I love to shop, hike, travel, read/study,
											decorate, and create. I have always been a left-brained
											thinker, but have found myself leaning a little bit more
											toward the right side of the brain as an adult.
										</p>
										<p>I rarely read novels, but I have read numerous nutrition and diet books (I know I am a nerd).  .</p>
										

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</c:forEach>
	</c:if>



	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>

</body>

</html>
