<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">





	<div class="alert alert-success">
		<h1>
			<strong>Success!</strong> Your account has been activated, you can
			now login. <br> Click <a
				href="${pageContext.request.contextPath}/login">here</a> to login.
		</h1>
	</div>

</div>
