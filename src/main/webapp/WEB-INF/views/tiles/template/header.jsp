<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header -->
<div class="header">
	<div class="container">
		<div class="header-grid">
			<div class="header-grid-left animated wow slideInLeft"
				data-wow-delay=".5s">
				<ul>
					<li>
						<i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>
						<a href="mailto:luannv@softech.vn">luannv@softech.vn</a>
					</li>
					<li>
						<i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>
						+84 985
						<span>134</span>
						094
					</li>
					<li>
						<i class="glyphicon glyphicon-book" aria-hidden="true"></i>
						<a href="${pageContext.request.contextPath}/register">Register</a>
					</li>
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<li>
								<i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>
								Hello
								<b>${pageContext.request.userPrincipal.name}</b>
							</li>
							<sec:authorize access="hasAuthority('Admin')">
								<li>
									<i class="glyphicon glyphicon-hand-right" aria-hidden="true"></i>
									<a href="${pageContext.request.contextPath}/admin/home/view">Dashboard</a>
								</li>
							</sec:authorize>
							<li>
								<i class="glyphicon glyphicon-log-out" aria-hidden="true"></i>
								<a href="javascript:formSubmit()"> Logout</a>
							</li>
							<sec:authorize
								access="hasAuthority('Dba') or hasAuthority('Admin') or hasAuthority('User')">
								<!-- For login user -->
								<c:url value="/j_spring_security_logout" var="logoutUrl" />
								<form action="${logoutUrl}" method="post" id="logoutForm">
									<%-- <input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> --%>
								</form>
								<script>
									function formSubmit() {
										document.getElementById("logoutForm")
												.submit();
									}
								</script>
							</sec:authorize>
						</c:when>
						<c:otherwise>
							<li>
								<i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>
								<a href="${pageContext.request.contextPath}/login">Login</a>
							</li>
						</c:otherwise>
					</c:choose>
					
				</ul>
			</div>
			<!-- <div class="header-grid-right animated wow slideInRight"
				data-wow-delay=".5s">
				<ul class="social-icons">
					<li>
						<a href="#" class="facebook"></a>
					</li>
					<li>
						<a href="#" class="twitter"></a>
					</li>
					<li>
						<a href="#" class="g"></a>
					</li>
					<li>
						<a href="#" class="instagram"></a>
					</li>
				</ul>
			</div> -->
			<div class="clearfix"></div>
		</div>
		<div class="logo-nav">
			<div class="logo-nav-left animated wow zoomIn" data-wow-delay=".5s">
				<h1>
					<a href="${pageContext.request.contextPath}">
						Best Store
						<span>Shop anywhere</span>
					</a>
				</h1>
			</div>
			<div class="logo-nav-left1">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header nav_2">
						<button type="button"
							class="navbar-toggle collapsed navbar-toggle1"
							data-toggle="collapse" data-target="#bs-megadropdown-tabs">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav">
							<li>
								<a href="${pageContext.request.contextPath}/">Home</a>
							</li>
							<!-- Mega Menu -->
							<li class="dropdown active">
								<a href="#" class="dropdown-toggle act" data-toggle="dropdown">
									Products
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu multi-column columns-3">
									<div class="row">
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												<h6>Men's Wear</h6>
												<c:forEach items="${men}" var="item" varStatus="status">
													<li>
														<a
															href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
													</li>
												</c:forEach>
											</ul>
										</div>
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												<h6>Women's Wear</h6>
												<c:forEach items="${women}" var="item" varStatus="status">
													<li>
														<a
															href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
													</li>
												</c:forEach>
											</ul>
										</div>
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												<h6>Kid's Wear</h6>
												<c:forEach items="${kids}" var="item" varStatus="status">
													<li>
														<a
															href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
													</li>
												</c:forEach>
											</ul>
										</div>
										<div class="clearfix"></div>
									</div>
								</ul>
							</li>
							
							<li>
								<a href="${pageContext.request.contextPath}/views/feedback">Mail Us</a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
			
			<div class="logo-nav-right">
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form action="${pageContext.request.contextPath}/views/viewproductsearch" method="get">
							<input class="sb-search-input"
								placeholder="Enter your search term..." type="search"
								id="search" name = "keyword">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
				<!-- search-scripts -->
				<script src="<c:url value="/resources/js/classie.js"/>"></script>
				<script src="<c:url value="/resources/js/uisearch.js"/>"></script>
				<script>
					new UISearch(document.getElementById('sb-search'));
				</script>
				<!-- //search-scripts -->
			</div>
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:setLocale value="vi_VN" scope="session" />
			<div class="header-right">
				<div class="cart box_1">
					<a href="${pageContext.request.contextPath}/shopping/checkout">
						<h3>
							<div class="total">
								<span class="simpleCart_total">
									<c:set var="total" value="${0}" />
									<!-- <li>Total Service Charges <i>-</i> <span>$15.00</span></li> -->
									<c:forEach items="${cartsSession}" var="item">
										<c:choose>
											<c:when
												test="${item.product.discountStartDate le now && item.product.discountEndDate ge now}">
												<c:set var="discountafter" value="${1-item.product.discount}"
													scope="page" />
											</c:when>
											<c:otherwise>
												<c:set var="discountafter" value="1" scope="page" />
											</c:otherwise>
										</c:choose>
										<c:set var="total"
											value="${total + item.product.price*item.quantity*discountafter}" />
									</c:forEach>
									<fmt:formatNumber value="${total}" type="currency" />
									<c:set var="totalitem" value="${0}" />
									<!-- <li>Total Service Charges <i>-</i> <span>$15.00</span></li> -->
									<c:forEach items="${cartsSession}" var="item">
										<c:set var="totalitem" value="${totalitem + item.quantity}" />
									</c:forEach>
								</span>
								<span class="simpleCart_totalitem">
								(${totalitem}
								
								items)
								</span>
							</div>
							<img src="<c:url value="/resources/images/bag.png" />" alt="" />
						</h3>
					</a>
					<p>
						<a href="javascript:void(0);" onclick="deleteallitem();"
							class="simpleCart_empty">Empty Cart</a>
					</p>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function getXMLHttpRequest() {
		var xmlHttpReq = false;
		if (window.XMLHttpRequest) {
			xmlHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			try {
				xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (exp1) {
				try {
					xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (exp2) {
					xmlHttpReq = false;
				}
			}
		}
		return xmlHttpReq;
	}

	function deleteallitem() {
		var xmlHttpRequest = getXMLHttpRequest();
		xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);

		xmlHttpRequest
				.open(
						"GET",
						"${pageContext.request.contextPath}/shopping/deleteallitemajax",
						true);
		xmlHttpRequest.send();
	}

	
	
	function showCartInfo(response){
		var obj = JSON.parse(response);
		var arr = obj.jsonObject; //list (mang) cart
		console.log("Array length: "+arr.length);		
		var i;
		var totalprice = 0;
		var totalitem = 0;
		var out='';
		for(i = 0; i < arr.length; i++){			
			totalitem += arr[i].quantity;
			var todaysDate = new Date();
			if (arr[i].product.discountStartDate != null && arr[i].product.discountEndDate != null
					&& arr[i].product.discount != null) {
				// Create date from input value
				var discountStartDate = new Date(arr[i].product.discountStartDate);
				var discountEndDate = new Date(arr[i].product.discountEndDate);
				// call setHours to take the time out of the comparison
				if (discountStartDate.setHours(0, 0, 0, 0) < todaysDate
						.setHours(0, 0, 0, 0)
						&& todaysDate.setHours(0, 0, 0, 0) < discountEndDate.setHours(0, 0,
								0, 0)) {
					// discount
					totalprice += arr[i].product.price * (1-arr[i].product.discount) * arr[i].quantity;
					continue;
				} else {
					// ko discount
					totalprice += arr[i].product.price * arr[i].quantity;
					continue;
				}
			} else {
				// ko discount
				totalprice += arr[i].product.price *  arr[i].quantity;
				continue;
			}
		}
		$(".simpleCart_total").text(totalprice + "đ");
		$(".simpleCart_totalitem").text("("+totalitem+" items)");
		
	}
	
</script>
<!-- //header -->