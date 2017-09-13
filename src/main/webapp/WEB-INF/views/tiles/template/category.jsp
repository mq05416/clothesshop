<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="products">
	<div class="container">

		<!-- left category -->
		<div class="col-md-4 products-left">
			<%-- <div class="filter-price animated wow slideInUp" data-wow-delay=".5s">
				<h3>Filter By Price</h3>
				<ul class="dropdown-menu1">
					<li><a href="">
							<div id="slider-range"></div> <input type="text" id="amount"
							style="border: 0" />
					</a></li>
				</ul>
				
				
				<script type='text/javascript'>
					//<![CDATA[ 
					$(window)
							.load(
									function() {
										$("#slider-range")
												.slider(
														{
															range : true,
															min : 0,
															max : 100000,
															values : [ 20000,
																	80000 ],
															slide : function(
																	event, ui) {
																$("#amount")
																		.val(
																				"$"
																						+ ui.values[0]
																						+ " - $"
																						+ ui.values[1]);
															}
														});
										$("#amount")
												.val(
														"$"
																+ $(
																		"#slider-range")
																		.slider(
																				"values",
																				0)
																+ " - $"
																+ $(
																		"#slider-range")
																		.slider(
																				"values",
																				1));

									});//]]>
				</script>
				
				<script type="text/javascript"
					src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
				<!---->
			</div> --%>
			<div class="categories animated wow slideInUp" data-wow-delay=".5s">
				<h3>Categories</h3>
				<ul class="cate">
					<li>
						<a href="">Men</a>
						<span></span>
					</li>
					<ul>
						<c:forEach items="${men}" var="item" varStatus="status">
							<li>
								<a
									href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
							</li>
						</c:forEach>
					</ul>




					<li>
						<a href="">Women</a>
						<span></span>
					</li>
					<ul>


						<c:forEach items="${women}" var="item" varStatus="status">
							<li>
								<a
									href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
							</li>
						</c:forEach>



					</ul>

					<li>
						<a href="">Kids</a>
						<span></span>
					</li>
					<ul>


						<c:forEach items="${kids}" var="item" varStatus="status">
							<li>
								<a
									href="${pageContext.request.contextPath}/views/viewproductlist/${item.id}/1/9">${item.name}</a>
							</li>
						</c:forEach>



					</ul>

				</ul>
			</div>
			<div class="new-products animated wow slideInUp" data-wow-delay=".5s">
				<h3>New Products</h3>
				<div class="new-products-grids">


					<c:forEach items="${productslatest}" var="item" varStatus="status">

						<div class="new-products-grid">
							<div class="new-products-grid-left">
								<a href="${pageContext.request.contextPath}/views/viewproductdetails/${item.id}">
									<img src="<c:url value="/images/${item.image}" />" alt=" "
										class="img-responsive" />
								</a>
							</div>
							<div class="new-products-grid-right">
								<h4>
									<a href="${pageContext.request.contextPath}/views/viewproductdetails/${item.id}">${item.name}</a>
								</h4>
								<div class="rating">
									<span class="stars">${item.rating}</span>
									
									<div class="clearfix"></div>
								</div>
								<div
									class="simpleCart_shelfItem new-products-grid-right-add-cart">
									<p>
										<span class="item_price">${item.price} đ </span> 
										<a class="item_add" href="${pageContext.request.contextPath}/shopping/checkout/${item.id}">add to cart </a>
									</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

					</c:forEach>




				</div>
			</div>
			<div class="men-position animated wow slideInUp" data-wow-delay=".5s">
				<a href="single.html">
					<img src="<c:url value="/resources/images/27.jpg"/>" alt=" "
						class="img-responsive" />
				</a>
				<div class="men-position-pos">
					<h4>Summer collection</h4>
					<h5>
						<span>55%</span>
						Flat Discount
					</h5>
				</div>
			</div>
		</div>
		<!-- end left category -->