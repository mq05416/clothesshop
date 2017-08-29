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
			<li class="active">Register Page</li>
		</ol>
	</div>
</div>
<!-- //breadcrumbs -->
<!-- register -->
<div class="register">
	<div class="container">
		<h3 class="animated wow zoomIn" data-wow-delay=".5s">Register
			Here</h3>
		
		<div class="login-form-grids">
			<h5 class="animated wow slideInUp" data-wow-delay=".5s">profile
				information</h5>
			<br>
			<div style="color: red">
				<b>${error}</b>
			</div>
			<br>
			<form class="animated wow slideInUp" data-wow-delay=".5s"
				action="${pageContext.request.contextPath}/register" method="POST">
				<input type="text" placeholder="Username..." required=" "
					name="username"> <input type="text"
					placeholder="First Name..." required=" " name="firstname">
				<input type="text" placeholder="Last Name..." required=" "
					name="lastname">

				<!-- <div class="register-check-box animated wow slideInUp" data-wow-delay=".5s">
					<div class="check">
						<label class="checkbox"><input type="checkbox" name="checkbox1"><i> </i>Subscribe to Newsletter</label>
					</div>
				</div> -->
				<h6 class="animated wow slideInUp" data-wow-delay=".5s">Login
					information</h6>

				<input type="email" placeholder="Email Address" required=" "
					name="email"> <input type="password" placeholder="Password"
					required=" " name="password1"> <input type="password"
					placeholder="Password Confirmation" required=" " name="password2">
				<div class="register-check-box">
					<div class="check">
						<label class="checkbox"><input type="checkbox"
							name="checkbox2"><i> </i>I accept the terms and
							conditions</label>
					</div>
				</div>
				
					<input type="submit" value="Register">
			</form>
		</div>
		<div class="register-home animated wow slideInUp" data-wow-delay=".5s">
			<a href="${pageContext.request.contextPath}">Home</a>
		</div>
	</div>
</div>
<!-- //register -->