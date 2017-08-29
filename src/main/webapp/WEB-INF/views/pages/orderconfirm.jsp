<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<li class="active">Order Confirm Page</li>
		</ol>
	</div>
</div>
<!-- //breadcrumbs -->
<!-- checkout -->
<div class="container wrapper">
	<div class="row cart-head">
		<div class="container">
			<div class="row">
				<p></p>
			</div>

			<div class="row">
				<p></p>
			</div>
		</div>
	</div>
	<div class="row cart-body">
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/shopping/confirmorder">
			<div
				class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
				<!--REVIEW ORDER-->
				<div class="panel panel-info">
					<div class="panel-heading"
						style="background-color: #D8703F; color: white">
						Review Order
						<div class="pull-right">
							<small>
								<a class="afix-1"
									href="${pageContext.request.contextPath}/shopping/checkout"
									style="color: white">Edit Cart</a>
							</small>
						</div>
					</div>
					<div class="panel-body">

						<fmt:setLocale value="vi_VN" scope="session" />

						<c:forEach items="${cartsSession}" var="item">
							<div class="form-group">
								<div class="col-sm-3 col-xs-3">
									<img class="img-responsive"
										src="<c:url value="/images/${item.product.image}" />" />
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="col-xs-12">${item.product.name}</div>
									<div class="col-xs-12">
										<small>
											Quantity:
											<span>${item.quantity }</span>
										</small>
									</div>
								</div>
								<div class="col-sm-3 col-xs-3 text-right">
									<h6>
										<jsp:useBean id="now" class="java.util.Date" />
										<c:choose>
											<c:when
												test="${item.product.discountStartDate le now && item.product.discountEndDate ge now  && item.product.discount ne null}">

												<fmt:formatNumber
													value="${(1-item.product.discount)*item.product.price}"
													type="currency" />
											</c:when>
											<c:otherwise>

												<fmt:formatNumber value="${item.product.price}"
													type="currency" />

											</c:otherwise>
										</c:choose>





									</h6>
								</div>
							</div>
							<div class="form-group">
								<hr />
							</div>
						</c:forEach>






						<div class="form-group">
							<div class="col-xs-12">
								<strong>Order Total</strong>
								<div class="pull-right">

									<c:set var="total" value="${0}" />
									<!-- <li>Total Service Charges <i>-</i> <span>$15.00</span></li> -->
									<c:forEach items="${cartsSession}" var="item">
										<c:choose>
											<c:when
												test="${item.product.discountStartDate le now && item.product.discountEndDate ge now}">
												<c:set var="discountafter"
													value="${1-item.product.discount}" scope="page" />
											</c:when>
											<c:otherwise>
												<c:set var="discountafter" value="1" scope="page" />
											</c:otherwise>
										</c:choose>
										<c:set var="total"
											value="${total + item.product.price*item.quantity*discountafter}" />
									</c:forEach>



									<span>
										<fmt:formatNumber value="${total}" type="currency" />
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--REVIEW ORDER END-->
			</div>
			<div
				class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
				<!--SHIPPING METHOD-->
				<div class="panel panel-info">
					<div class="panel-heading"
						style="background-color: #D8703F; color: white">Address</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="col-md-12">
								<h4>Shipping Address</h4>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>Country:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" class="form-control" name="country" value="" required/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6 col-xs-12">
								<strong>First Name:</strong>
								<input type="text" name="first_name" class="form-control" required
									value="" />
							</div>
							<div class="span1"></div>
							<div class="col-md-6 col-xs-12">
								<strong>Last Name:</strong>
								<input type="text" name="last_name" class="form-control" required
									value="" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>Address:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="address" class="form-control" value="" required/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>City:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="city" class="form-control" value="" required />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>State:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="state" class="form-control" value="" required />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>Zip / Postal Code:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="zip_code" class="form-control" value="" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>Phone Number:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="phone_number" class="form-control"
									value="" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<strong>Email Address:</strong>
							</div>
							<div class="col-md-12">
								<input type="text" name="email_address" class="form-control" 
									value=""  required/>
							</div>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<button type="submit" class="btn btn-primary btn-submit-fix">Next</button>
					</div>
				</div>
				<!--SHIPPING METHOD END-->
				<!--CREDIT CART PAYMENT-->
				<!-- <div class="panel panel-info">
					<div class="panel-heading"
						style="background-color: #D8703F; color: white">
						<span>
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						Secure Payment
					</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="col-md-12">
								<strong>Payment methods:</strong>
							</div>
							<div class="col-md-12">
								<div class="radio">
									<label>
										<input type="radio" name="payment" value="Live">
										Live
									</label>
								</div>
								<div class="radio">
									<label>
										<input type="radio" name="payment" value="Bank Transfer">
										Bank Transfer
									</label>
								</div>

							</div>
						</div>


					</div>
				</div> -->
				<!--CREDIT CART PAYMENT END-->
			</div>

		</form>
	</div>
	<div class="row cart-footer"></div>
</div>