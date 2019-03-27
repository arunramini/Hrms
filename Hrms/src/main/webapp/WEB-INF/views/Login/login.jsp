<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!------ Include the above in your HEAD tag ---------->
<head>
<spring:url value="/resources/style.css" var="mainCss" />
<spring:url value="/resources/error.css" var="errCss" />
<link href="${mainCss}" rel="stylesheet" />
<link href="${errCss}" rel="stylesheet" />
<title>LogIn Page</title>
</head>
<body class="loginId">

	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div class="login-box col-md-12">
						<form:form id="login-form" class="form" action="validUser"
							modelAttribute="loginForm">
							<h3 class="text-center text-info">Login</h3>

							<div class="form-group">
								<label for="loginForm.username" class="text-info">UserName</label><br>
								<form:input path="username" class="form-control" />
							</div>
							<div class="form-group">
								<label for="loginForm.password" class="text-info">Password</label><br>
								<form:input path="password" class="form-control" />
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"><span>Remember
										me</span> <span><input id="remember-me" name="remember-me"
										type="checkbox"></span></label><br> <input type="submit"
									name="submit" class="btn btn-info btn-md" value="submit">
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>