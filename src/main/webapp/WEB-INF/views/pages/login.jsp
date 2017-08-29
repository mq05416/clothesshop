<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- breadcrumbs -->
<div class="breadcrumbs">
	<div class="container">
		<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
			data-wow-delay=".5s">
			<li>
				<a href="${pageContext.request.contextPath}">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					Home
				</a>
			</li>
			<li class="active">Login Page</li>
		</ol>
	</div>
</div>
<!-- //breadcrumbs -->
<!-- login -->
<div class="login">
	<div class="container">
		<h3 class="animated wow zoomIn" data-wow-delay=".5s">Login Form</h3>
		
		<div class="login-form-grids animated wow slideInUp"
			data-wow-delay=".5s">
			<br>
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<font color="red">
					Invalid username or password or your account has not been activated
					yet. Did you forget your password?
					<br />
					<br />
				</font>
			</c:if>
			<br>
			<%-- <form action = "${pageContext.request.contextPath}/authen/login" method="post"> --%>
			<form action="<c:url value='j_spring_security_check' />"
				method="post">
				<input type="text" placeholder="Username..." required=" "
					name="username">
				<input type="password" placeholder="Password" required=" "
					name="password">
				<%-- <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> --%>
				<div class="forgot">
					<a href="${pageContext.request.contextPath}/resetpassword">Forgot
						Password?</a>
				</div>
				<input name="submit" type="submit" value="Login">
			</form>
		</div>
		<h4 class="animated wow slideInUp" data-wow-delay=".5s">For New
			People</h4>
		<p class="animated wow slideInUp" data-wow-delay=".5s">
			<a href="${pageContext.request.contextPath}/register">Register
				Here</a>
			(Or) go back to
			<a href="${pageContext.request.contextPath}">
				Home
				<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
			</a>
		</p>
	</div>
</div>
<!-- //login -->