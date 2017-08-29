<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- breadcrumbs -->
<div class="breadcrumbs">
	<div class="container">
		<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
			data-wow-delay=".5s">
			<li><a href="${pageContext.request.contextPath}"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
			<li class="active">Login Page</li>
		</ol>
	</div>
</div>
<!-- //breadcrumbs -->
<!-- login -->
<div class="login">
	<div class="container">
		<h3 class="animated wow zoomIn" data-wow-delay=".5s">Reset
			Password Form</h3>
		<p class="est animated wow zoomIn" data-wow-delay=".5s">Enter
			email address to reset password</p>
		<div class="login-form-grids animated wow slideInUp"
			data-wow-delay=".5s">
			<div style="color: red">
				<b>${error}</b>
			</div>
			<br> <br>
			<%-- <form action = "${pageContext.request.contextPath}/authen/login" method="post"> --%>
			<form action="${pageContext.request.contextPath}/resetpassword"
				method="post">
				<input type="email" placeholder="Email Address" required=" "
					name="email"> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
					name="submit" type="submit" value="Reset Password">
			</form>






		</div>

	</div>
</div>
<!-- //login -->