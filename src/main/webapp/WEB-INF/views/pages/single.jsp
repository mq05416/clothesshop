<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!-- chi tiet san pham ben  phai -->
<div class="col-md-8 single-right">
	<div class="col-md-5 single-right-left animated wow slideInUp"
		data-wow-delay=".5s">
		<div class="flexslider">
			<ul class="slides">
				<li data-thumb="<c:url value="/images/${product.image}" />">
					<div class="thumb-image">
						<img src="<c:url value="/images/${product.image}" />"
							data-imagezoom="true" class="img-responsive">
					</div>
				</li>
				<li data-thumb="<c:url value="/images/${product.image}" />">
					<div class="thumb-image">
						<img src="<c:url value="/images/${product.image}" />"
							data-imagezoom="true" class="img-responsive">
					</div>
				</li>
				<li data-thumb="<c:url value="/images/${product.image}" />">
					<div class="thumb-image">
						<img src="<c:url value="/images/${product.image}" />"
							data-imagezoom="true" class="img-responsive">
					</div>
				</li>
			</ul>
		</div>
		<!-- flixslider -->
		<script defer
			src="<c:url value='/resources/js/jquery.flexslider.js'/>"></script>



		<link rel="stylesheet"
			href="<c:url value='/resources/css/flexslider.css'/>" type="text/css"
			media="screen" />



		<script>
			// Can also be used with $(document).ready()
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					controlNav : "thumbnails"
				});
			});
		</script>
		<!-- flixslider -->
	</div>
	<div
		class="col-md-7 single-right-left simpleCart_shelfItem animated wow slideInRight"
		data-wow-delay=".5s">
		<h3>${product.name}</h3>
		<jsp:useBean id="now" class="java.util.Date" />
		<c:choose>
			<c:when
				test="${product.discountStartDate le now && product.discountEndDate ge now && product.discount ne null}">
				<c:set var="discountafter" value="${1-product.discount}"
					scope="page" />
			</c:when>
			<c:otherwise>
				<c:set var="discountafter" value="1" scope="page" />
			</c:otherwise>
		</c:choose>




		<h4>
			<span>
				<fmt:formatNumber value="${product.price*discountafter}"
					type="currency" />
			</span>
		</h4>
		<div id="star-rating">
			<input type="radio" name="example" class="rating" value="1" />
			<input type="radio" name="example" class="rating" value="2" />
			<input type="radio" name="example" class="rating" value="3" />
			<input type="radio" name="example" class="rating" value="4" />
			<input type="radio" name="example" class="rating" value="5" />
		</div>


		<div class="description">
			<h5>
				<i>Description</i>
			</h5>
			<p>${product.description}</p>
		</div>
		<div class="color-quality">
			<div class="color-quality-left">
				<h5>Color :</h5>
				<ul>
					<li>
						<a href="#">
							<span></span>
							Red
						</a>
					</li>
					<li>
						<a href="#" class="brown">
							<span></span>
							Yellow
						</a>
					</li>
					<li>
						<a href="#" class="purple">
							<span></span>
							Purple
						</a>
					</li>
					<li>
						<a href="#" class="gray">
							<span></span>
							Violet
						</a>
					</li>
				</ul>
			</div>
			
			<div class="clearfix"></div>
		</div>
		<div class="occasional">
			<h5>Occasion :</h5>
			<div class="colr ert">
				<label class="radio">
					<input type="radio" name="radio" checked="">
					<i></i>
					Casual Wear
				</label>
			</div>
			<div class="colr">
				<label class="radio">
					<input type="radio" name="radio">
					<i></i>
					Party Wear
				</label>
			</div>
			<div class="colr">
				<label class="radio">
					<input type="radio" name="radio">
					<i></i>
					Formal Wear
				</label>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="occasion-cart">
			<a class="item_add"
				href="${pageContext.request.contextPath}/shopping/checkout/${product.id}">add
				to cart </a>
		</div>
		<div class="social">
			<div class="social-left">
				<p>Share On :</p>
			</div>
			<div class="social-right">
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
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="bootstrap-tab animated wow slideInUp" data-wow-delay=".5s">
		<div class="bs-example bs-example-tabs" role="tabpanel"
			data-example-id="togglable-tabs">
			<ul id="myTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#home" id="home-tab" role="tab" data-toggle="tab"
						aria-controls="home" aria-expanded="true">Description</a>
				</li>
				
			</ul>
			<div id="myTabContent" class="tab-content">
				<div role="tabpanel"
					class="tab-pane fade in active bootstrap-tab-text" id="home"
					aria-labelledby="home-tab">
					<h5>Product Brief Description</h5>
					<p>${product.description}</p>
				</div>
				
			</div>
		</div>
	</div>
	<br><br>
	<div class="fb-comments" data-href="" data-colorscheme="light"
   data-numposts="5" data-width="740"></div>
	
</div>
<!-- end chi tiet san pham ben phai -->
<div class="clearfix"></div>
<script defer src="<c:url value='/resources/js/imagezoom.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('span.stars').stars();
		$('#star-rating').rating(function(vote, event) {

			sendvote(vote);
		});
	});

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

	function sendvote(vote) {
		var xmlHttpRequest = getXMLHttpRequest();
		xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
		
		var queryString = "/" + vote + "/" + 
		${
			product.id
		}
		;
		
		xmlHttpRequest.open("GET",
				"${pageContext.request.contextPath}/views/sendvote"
						+ queryString, true);
		xmlHttpRequest.send();
	}

	function getReadyStateHandler(xmlHttpRequest) {
		return function() {

			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {

					

					var jsonObject = JSON.parse(xmlHttpRequest.responseText);

					var jsonFunction = jsonObject.jsonFunction;
					if (jsonFunction == "jsonfunction_deleteall")
						showCartInfo(xmlHttpRequest.responseText);

				} else {
					alert("HTTP error " + xmlHttpRequest.status + ": "
							+ xmlHttpRequest.statusText);
				}
			}
		};
	}
</script>
