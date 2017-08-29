<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">





	<div class="alert alert-danger">
		<h1>
			<strong>Error!</strong> Your account has not been activated yet, you
			can not now login. <br> Click <a
				href="${pageContext.request.contextPath}">here</a> to return home
			page.
		</h1>
	</div>

</div>
